package ru.isko.forms;

import lombok.*;


/**
 * 11/10/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class UserRegistrationForm {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String lastname;
    private boolean gender;
    private String bday;
    private String bmon;
    private String byear;
    private String city;
    private String telephone;
    private String photo;
}
