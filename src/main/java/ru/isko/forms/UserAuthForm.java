package ru.isko.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 11/11/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class UserAuthForm {

    private String enterEmail;
    private String enterPassword;

}
