package ru.isko.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Iskander Valiev
 * on 11/23/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class NewsForm {
    private String header;
    private String content;
    private String type;
}
