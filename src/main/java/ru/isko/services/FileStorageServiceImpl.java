package ru.isko.services;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.models.FileInfo;
import ru.isko.repositories.file_info.FileInfoRepository;
import ru.isko.utils.FileStorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * created by Iskander Valiev
 * on 12/1/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private FileStorageUtil fileStorageUtil;

    @Override
    public String saveFile(MultipartFile file) {
        //convert into database object
        FileInfo fileInfo = fileStorageUtil.convertFromMultipart(file);
        //save information about file
        fileInfoRepository.save(fileInfo);
        //move to our disk
        fileStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        //return new file name
        return fileInfo.getStorageFileName();
    }

    @SneakyThrows
    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo file = fileInfoRepository.findOneByStorageFileName(fileName);
        response.setContentType(file.getType());
        //get file input stream
        InputStream inputStream = new FileInputStream(new File(file.getUrl()));
        //copy file to response
        IOUtils.copy(inputStream, response.getOutputStream());
        //flush to buffer
        response.flushBuffer();
    }
}
