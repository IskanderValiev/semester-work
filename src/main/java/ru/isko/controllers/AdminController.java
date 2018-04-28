package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.isko.repositories.news.NewsRepository;
import ru.isko.services.AdminService;
import ru.isko.services.AuthenticationService;
import ru.isko.services.NewsService;

/**
 * created by Iskander Vaiev
 * on 11/17/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @GetMapping("/profile")
    public String getAdminPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        model.addAttribute(authenticationService.getUser(authentication));
        return "profile";
    }

    @GetMapping
    public String getNewPasswordOfUserPage(@ModelAttribute("model") ModelMap modelMap, @PathVariable("user-id") Long userId) {
        adminService.generateTempPassword(userId);
        return "";
    }


    @GetMapping("/homepage")
    public String openHomepage(@ModelAttribute("model")ModelMap model) {
//        model.addAttribute("lastnews", newsRepository.getLastNews());
        return "homepage";
    }

    @GetMapping("/contacts")
    public String openContacts() {
        return "contacts";
    }
}
