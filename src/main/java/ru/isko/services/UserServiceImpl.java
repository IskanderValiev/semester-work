package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.isko.forms.EditProfileForm;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by Iskander Valiev
 * on 11/30/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void update(User user, EditProfileForm editProfileForm) {
//        if (editProfileForm.getPhoto() != null && editProfileForm.getPhoto().length() != 0) {
//            user.setPhoto(editProfileForm.getPhoto());
//        }

        if (editProfileForm.getName() != null && editProfileForm.getName().length() != 0) {
            user.setName(editProfileForm.getName());
        }

        if (editProfileForm.getLastname() != null && editProfileForm.getLastname().length() != 0) {
            user.setLastname(editProfileForm.getLastname());
        }

        if (editProfileForm.getCurrpass() != null && editProfileForm.getCurrpass().length() != 0 && passwordEncoder.encode(editProfileForm.getCurrpass()).equals(user.getPassword())) {
            if (editProfileForm.getNewpass() != null && editProfileForm.getNewpass().length() != 0 && editProfileForm.getNewpass().equals(editProfileForm.getConfpass())) {
                user.setPassword(passwordEncoder.encode(editProfileForm.getNewpass()));
            } else {
                System.err.println("ошибка");
            }
        } else System.err.println("error" + " " + passwordEncoder.encode(editProfileForm.getCurrpass()).equals(user.getPassword()) + " " + user.getPassword());

        if (!editProfileForm.getBday().equals("Day") && editProfileForm.getBday() != null &&
                !editProfileForm.getBmon().equals("Month") && editProfileForm.getBmon() != null &&
                !editProfileForm.getByear().equals("Year") && editProfileForm.getByear() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date parser = null;
            try {
                parser = simpleDateFormat.parse(editProfileForm.getByear() + editProfileForm.getBmon() + editProfileForm.getBday());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date date = new java.sql.Date(parser != null ? parser.getTime() : 0);
            user.setBday(date);
        }

        if (!editProfileForm.getCity().equals("Choose city")) {
            user.setCity(editProfileForm.getCity());
        }

        if (editProfileForm.getEmail().length() != 0 && editProfileForm.getEmail() != null) {
            user.setEmail(editProfileForm.getEmail());
        }

        if (editProfileForm.getTelephone().length() != 0 && editProfileForm.getTelephone().length() == 11 && editProfileForm.getTelephone() != null && editProfileForm.getTelephone().toCharArray()[0] == '7') {
            user.setTelephone(editProfileForm.getTelephone());
        }

        usersRepository.save(user);
    }

    //$2a$10$chySAlLzamn06z4z9IIAR.9Z9JCsJp9TpGHV5YUeKnQRjgOPKUHua

    //$2a$10$x1hcfXz8G8EzpVDO33nUJupYT14Ocsb6uOQ7AwEl0YNt2Rbz7RCda


}
