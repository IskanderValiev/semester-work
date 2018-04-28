package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.security.state.State;
import ru.isko.services.VerifyService;

import java.util.Optional;

/**
 * created by Iskander Valiev
 * on 11/20/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @GetMapping("/registration/confirm/{user-link}")
    public String verify(@PathVariable("user-link") String link) {
        verifyService.verifyUser(link);
        return "redirect:/";
    }
}
