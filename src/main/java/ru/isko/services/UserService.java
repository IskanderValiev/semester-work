package ru.isko.services;

import ru.isko.forms.EditProfileForm;
import ru.isko.models.User;

public interface UserService {

    void update(User user,
                EditProfileForm editProfileForm);
}
