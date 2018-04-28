package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.isko.services.SystemService;

/**
 * created by Iskander Valiev
 * on 12/2/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class ResetPasswordController {

    @Autowired
    private SystemService service;

    @GetMapping("/reset/password/{user-link}")
    public String resetPass(@PathVariable("user-link")String link) {
        service.resetPassword(link);
        return "redirect:/signin";
    }
}
