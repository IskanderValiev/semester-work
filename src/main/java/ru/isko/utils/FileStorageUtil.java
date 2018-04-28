package ru.isko.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.models.FileInfo;
import ru.isko.services.AuthenticationService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * created by Iskander Valiev
 * on 12/1/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Component
public class FileStorageUtil {

    @Value("${storage.path}")
    private String storagePath;

    @Autowired
    private AuthenticationService authenticationService;

    public String getStoragePath() {
        return storagePath;
    }

    @SneakyThrows
    public void copyToStorage(MultipartFile file, String storageFileName) {
        Files.copy(file.getInputStream(), Paths.get(storagePath, storageFileName));
    }

    public FileInfo convertFromMultipart(MultipartFile file) {
        //getting file name
        String originalFileName = file.getOriginalFilename();

        //getting content-type
        String type = file.getContentType();

        //file size
        long size = file.getSize();

        //creating file name
        String storageName = createStorageName(originalFileName);

        //get url file (access inside tags)
        String fileUrl = getUrlOfFile(storageName);
        return FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(storageName)
                .url(fileUrl)
                .size(size)
                .type(type)
                .build();
    }

    private String getUrlOfFile(String storageFileName) {
        return storagePath + "/" + storageFileName;
    }

    private String createStorageName(String originalFileName) {
        String extension = FilenameUtils.getExtension(originalFileName);
        String newFileName = UUID.randomUUID().toString();
        return newFileName + "." + extension;
    }
}
