package ru.isko.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Iskander Valiev
 * on 11/30/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class EditProfileForm {
    private String name;
    private String lastname;
    private String currpass;
    private String newpass;
    private String confpass;
    private String bday;
    private String bmon;
    private String byear;
    private String city;
    private String photo;
    private String email;
    private String telephone;
}
