package ru.isko.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.isko.forms.UserAuthForm;
import ru.isko.repositories.users.UsersRepository;


/**
 * created by Iskander Vaiev
 * on 11/11/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Component
public class UserAuthFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UserAuthForm.class.getName());
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", "You have to fill email field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "You have to fill password field.");
    }
}
