package ru.isko.services;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {

    String saveFile(MultipartFile file);
    void writeFileToResponse(String fileName, HttpServletResponse response);

}
