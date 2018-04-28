package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.isko.forms.UserRegistrationForm;
import ru.isko.models.User;
import ru.isko.services.RegistrationService;
import ru.isko.services.SystemService;
import ru.isko.validators.UserRegistrationFormValidator;

import javax.validation.Valid;

/**
 * 11/11/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    @Autowired
    private SystemService service;

    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }

    @PostMapping(value = "/signup")
    public String signUp(@Valid @ModelAttribute("userForm")UserRegistrationForm userRegistrationForm, BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error",  errors.getAllErrors().get(0).getDefaultMessage());
            System.out.println(errors.getAllErrors().get(0).toString());
            return "redirect:/";
        }
        User user = registrationService.register(userRegistrationForm);
        System.out.println("successful registration");
        return "redirect:/confirm/"+user.getId();
    }

    @GetMapping(value = "/confirm/{user-id}")
    public String sendLink(@ModelAttribute("model")ModelMap model, @PathVariable("user-id") Long userId) {
        service.sendLink(userId);
        return "confirm";
    }
}
