package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.security.details.UsersDetailsImpl;

/**
 * 11/10/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Service
public class AuthentificatorServiceImpl implements AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUser(Authentication authentication) {
        UsersDetailsImpl currentUserDetails = (UsersDetailsImpl) authentication.getPrincipal();
        User currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        return usersRepository.findOne(currentUserId);
    }
}
