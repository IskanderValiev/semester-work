package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.isko.forms.UserRegistrationForm;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;
import ru.isko.security.role.Role;
import ru.isko.security.state.State;
import ru.isko.utils.LinkGenerator;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 11/10/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LinkGenerator linkGenerator;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User register(UserRegistrationForm userForm) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parser = null;
        try {
            parser = simpleDateFormat.parse(userForm.getByear() + userForm.getBmon() + userForm.getBday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date bday = new Date(parser != null ? parser.getTime() : 0);

        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .name(userForm.getName())
                .lastname(userForm.getLastname())
                .gender(userForm.isGender())
                .city(userForm.getCity())
                .bday(bday)
                .telephone(userForm.getTelephone())
                .role(Role.USER)
                .state(State.NOT_CONFIRMED)
                .hashLink(linkGenerator.generate())
                .build();
        usersRepository.save(user);
        smsService.sendMessage(userForm);
        return user;
    }

}
