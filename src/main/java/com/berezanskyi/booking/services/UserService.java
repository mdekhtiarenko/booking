package com.berezanskyi.booking.services;

import com.berezanskyi.booking.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user) throws IllegalAccessException;

    void editUser(String login, User editUser);

    @Transactional
    void deleteUserByLogin(String login);

    Optional<User> findUserByLogin(String login);

    List<User> getAllUsers();
}
