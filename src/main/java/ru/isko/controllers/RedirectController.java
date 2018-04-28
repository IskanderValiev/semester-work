package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.isko.forms.EditProfileForm;
import ru.isko.security.role.Role;
import ru.isko.services.AuthenticationService;
import ru.isko.services.UserService;

/**
 * created by Iskander Valiev
 * on 11/22/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class RedirectController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/editprofile")
    public String edit(EditProfileForm editProfileForm, Authentication authentication) {
        userService.update(authenticationService.getUser(authentication), editProfileForm);
        return "redirect:/user/profile";
    }


}
