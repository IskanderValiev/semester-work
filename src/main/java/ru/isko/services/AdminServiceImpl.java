package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.utils.PasswordGenerator;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by Iskander Valiev
 * on 11/17/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailService emailService;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Transactional
    @Override
    public void generateTempPassword(Long userId) {
        Optional<User> existedUser = usersRepository.findById(userId);

        User admin = usersRepository.findOne(1L);

        if (!existedUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = existedUser.get();

        String tempPassword = passwordGenerator.generate();

        user.setTempPassword(encoder.encode(tempPassword));

        usersRepository.save(user);

        executorService.submit(() -> {
            emailService.sendMail("<h2 style=\"color = red\">" + tempPassword + "</h1",
                    "Temproary password for mr. " + user.getLastname(), user.getEmail());
        });

    }
}
