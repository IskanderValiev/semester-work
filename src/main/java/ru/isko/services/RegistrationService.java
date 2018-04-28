package ru.isko.services;

import ru.isko.forms.UserRegistrationForm;
import ru.isko.models.User;

/**
 * 11/10/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public interface RegistrationService {

    User register(UserRegistrationForm userForm);

}
