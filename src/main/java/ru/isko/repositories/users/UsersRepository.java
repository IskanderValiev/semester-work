package ru.isko.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.User;

import java.util.Optional;

/**
 * Created by isko on 9/25/17.
 */
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String username);

    Optional<User> findById(Long id);

    Optional<User> findByHashLink(String hashLink);

    Optional<User> findByResetPasswordLink(String link);
}
