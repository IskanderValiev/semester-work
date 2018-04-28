package ru.isko.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.isko.models.User;
import ru.isko.repositories.users.UsersRepository;

import java.util.Collection;
import java.util.Optional;


/**
 * created by Iskander Vaiev
 * on 11/17/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();

        String password = authentication.getCredentials().toString();

        Optional<User> userOptional = usersRepository.findOneByEmail(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (!passwordEncoder.matches(password, user.getPassword())) {

                if (passwordEncoder.matches(password, user.getTempPassword())) {
                    user.setTempPassword(null);
                    usersRepository.save(user);
                } else {
                    throw new BadCredentialsException("Wrong login or password");
                }
            }
        } else {
            throw new BadCredentialsException("Wrong login or password");
        }
        UserDetails details = userDetailsService.loadUserByUsername(username);

        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();

        return new UsernamePasswordAuthenticationToken(details, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
