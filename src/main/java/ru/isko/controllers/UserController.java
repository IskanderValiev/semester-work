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
import ru.isko.repositories.countries.CountriesRepository;
import ru.isko.repositories.news.NewsRepository;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.services.AuthenticationService;
import ru.isko.services.NewsService;
import ru.isko.services.UserService;

/**
 * created by Iskander Valiev
 * on 11/26/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @GetMapping("/homepage")
    public String openHomepage(@ModelAttribute("model")ModelMap model) {
        model.addAttribute("lastnews", newsService.getLastNews());
        return "homepage";
    }

    @GetMapping("/editprofile")
    public String openEditProfilePage(@ModelAttribute("model")ModelMap model, Authentication authentication) {
        model.addAttribute("user", authenticationService.getUser(authentication));
        return "edit_profile";
    }

    @GetMapping("/contacts")
    public String openContactsPage() {
        return "contacts";
    }

    @GetMapping("/teams")
    public String openTeamsPage(@ModelAttribute("model")ModelMap model, Authentication authentication) {
        model.addAttribute("countries", countriesRepository.findAll());
        model.addAttribute("user", authenticationService.getUser(authentication));
        return "teams";
    }

    @GetMapping("/profile/{user-id}")
    public String getUserProfileImage(@ModelAttribute("model")ModelMap model, @PathVariable("user-id")Long id, Authentication authentication) {
        if (authenticationService.getUser(authentication).getId().equals(id)) {
            return "redirect:/user/profile";
        }
        model.addAttribute("user", usersRepository.findOne(id));
        return "user_profile";
    }
}
