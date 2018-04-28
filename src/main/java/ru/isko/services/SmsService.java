package ru.isko.services;


import ru.isko.forms.UserRegistrationForm;

import java.util.concurrent.Future;

/**
 * created by Iskander Valiev
 * on 11/25/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public interface SmsService {

    Future<Boolean> sendMessage(UserRegistrationForm form);
}
