package ru.isko.services;

import org.springframework.security.core.Authentication;
import ru.isko.models.User;


public interface AuthenticationService {
    User getUser(Authentication authentication);
}
