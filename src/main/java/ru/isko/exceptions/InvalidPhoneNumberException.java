package ru.isko.exceptions;

/**
 * created by Iskander Valiev
 * on 11/25/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public class InvalidPhoneNumberException extends Exception {

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
