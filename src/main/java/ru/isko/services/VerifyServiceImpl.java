package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.security.state.State;

import java.util.Optional;

/**
 * created by Iskander Valiev
 * on 11/24/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void verifyUser(String link) {
        Optional<User> user = usersRepository.findByHashLink(link);

        if (!user.isPresent()) {
            throw new IllegalArgumentException("Bad link");
        }

        User existedUser = user.get();
        existedUser.setState(State.CONFIRMED);

        usersRepository.save(existedUser);
    }
}
