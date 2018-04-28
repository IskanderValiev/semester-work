package ru.isko.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * created by Iskander Valiev
 * on 11/18/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Component
public class LinkGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }

}