package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.utils.LinkGenerator;
import ru.isko.utils.PasswordGenerator;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by Iskander Valiev
 * on 11/18/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private LinkGenerator linkGenerator;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Transactional
    @Override
    public void sendLink(Long userId) {
        Optional<User> existedUser = usersRepository.findById(userId);

        if (!existedUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = existedUser.get();

        String link = "http://localhost:8080/registration/confirm/" + user.getHashLink();

        executorService.submit(() -> {
            emailService.sendMail("<img src=\"/images/background.png\" style=\"width:100%; height:100px;\"> <br><br><br>" +
                            "We are glad to see you in our The FIFA World Cup™ 2018 Russia." +
                            "Use the link below to confirm your account: <br><br><br>" +
                            "<a href=\"" + link + "\">" + link + "</a> <br><br><br> This is the automatic message, please, do not reply. <br>" +
                            "If you do not know anything about this message, please, ignore it. <br>" +
                            "Technical support: <strong>iskand.valiev@yandex.ru</strong> <br>" +
                            "<b>Sincerely yours,</b> <br>" +
                            "<b>Iskander Valiev (general director of Iskander Developer Company)</b>",
                    "Confirming link for " + user.getName() + user.getLastname(),
                            user.getEmail());
        });

    }

    @Override
    public void generateTempPassword(Long userId) {
        Optional<User> existedUser = usersRepository.findById(userId);

        if (!existedUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = existedUser.get();

        String generatedPassword = passwordGenerator.generate();
        String password = passwordEncoder.encode(generatedPassword);

        String resetLink = linkGenerator.generate();

        executorService.submit(() -> {
            emailService.sendMail("We received request to reset current password for your account. " +
                            "If you actually want to reset your current password, please, <a href=\"http://localhost:8080/reset/password/" + resetLink + "\">click this link to reset your password</a>. <br> " +
                    "New password: " + generatedPassword + " <br>" +
                    "You can use this password to enter portal. <br>" +
                            "This is the automatic message, please, do not reply. <br>" +
                            "If you do not know anything about this message, please, ignore it. <br>" +
                            "Technical support: <strong>iskand.valiev@yandex.ru</strong> <br>" +
                            "<b>Sincerely yours,</b> <br>" +
                            "<b>Iskander Valiev (general director of Iskander Developer Company)</b>",
                    "New password for mr. " + user.getLastname(),
                     user.getEmail());
        });

        user.setResetPasswordLink(resetLink);
        user.setTempPassword(password);
        usersRepository.save(user);
    }

    @Override
    public void resetPassword(String userLink) {
        Optional<User> user = usersRepository.findByResetPasswordLink(userLink);
        if (!user.isPresent()) {
            throw new IllegalArgumentException("There is no user");
        }

        User existedUser = user.get();
        existedUser.setPassword(existedUser.getTempPassword());
        existedUser.setTempPassword(null);
        usersRepository.save(existedUser);

    }
}
