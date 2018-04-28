package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.models.FileInfo;
import ru.isko.models.User;
import ru.isko.repositories.file_info.FileInfoRepository;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.services.AuthenticationService;
import ru.isko.services.FileStorageService;

import javax.servlet.http.HttpServletResponse;

/**
 * created by Iskander Valiev
 * on 12/2/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class StorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/files")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file")MultipartFile file, Authentication authentication) {
        String filePath = fileStorageService.saveFile(file);

        FileInfo fileInfo = fileInfoRepository.findOneByStorageFileName(filePath);
        User user = authenticationService.getUser(authentication);
        user.setPhoto(fileInfo);
        usersRepository.save(user);

        return ResponseEntity
                .ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileName, response);
    }
}
