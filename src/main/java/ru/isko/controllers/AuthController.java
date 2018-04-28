package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.security.role.Role;
import ru.isko.services.AdminService;
import ru.isko.services.AuthenticationService;
import ru.isko.services.SystemService;
import ru.isko.validators.UserAuthFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 11/10/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Controller
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserAuthFormValidator userAuthFormValidator;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private SystemService systemService;

    @GetMapping("/signin")
    public String login(@ModelAttribute("model") ModelMap model, Authentication authentication, @RequestParam Optional<String> error) {
        if (authentication != null) {
            System.out.println(authentication.toString());
            return "redirect:/";
        }
        model.addAttribute("error", error);
        return "index";
    }

    @GetMapping("/exit")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/signin";
    }

    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/user/profile";
        }
        return "redirect:/signin";
    }


    @GetMapping("/user/profile")
    public String getProfilePage(Authentication authentication, @ModelAttribute("model") ModelMap modelMap) {
        modelMap.addAttribute(authenticationService.getUser(authentication));
        return "profile";
    }

    @GetMapping("/restoring")
    public String restoring(@ModelAttribute("model") ModelMap model) {
        return "restoring";
    }

    @PostMapping(value = "/tempPassword")
    public String tempPassword(@ModelAttribute("model") ModelMap model, HttpServletRequest request) {
        String userEmail = request.getParameter("email");

        Optional<User> existedUser = usersRepository.findOneByEmail(userEmail);

        if (existedUser.isPresent()) {
            User user = existedUser.get();
            systemService.generateTempPassword(user.getId());
        }
        return "newpassword";
    }
<<<<<<< Updated upstream
//
//    @GetMapping(value = "/login")
//    public String redirect() {
//        return "redirect:/signin";
//    }
=======
>>>>>>> Stashed changes
}
