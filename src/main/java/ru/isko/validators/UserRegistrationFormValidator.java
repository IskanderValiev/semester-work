package ru.isko.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.isko.forms.UserRegistrationForm;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;

import java.util.Optional;

/**
 * 11/11/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Component
public class UserRegistrationFormValidator implements Validator {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UserRegistrationForm.class.getName());
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;
        Optional<User> existedUser = usersRepository.findOneByEmail(form.getEmail());

        if (existedUser.isPresent()) {
            errors.reject("existed.login", "User with such email already exists.");
        }

        if (form.getTelephone().length() != 11) {
            errors.reject("bad.number", "Invalid phone number.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", "You have to fill email field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "You have to fill password field.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "empty.confirmpassword", "You have to fill confirming password field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty.name", "You have to fill name field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "empty.lastname", "You have to fill lastname field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "empty.phone", "You have to fill phone number field.");


    }
}
