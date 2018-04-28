package ru.isko.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * created by Iskander Vaiev
 * on 11/17/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Component
public class PasswordGenerator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
