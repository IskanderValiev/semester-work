package ru.isko.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import ru.isko.security.config.WebSecurityConfig;

/**
 * created by Iskander Valiev
 * on 16.04.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(WebSecurityConfig.class);
    }
}
