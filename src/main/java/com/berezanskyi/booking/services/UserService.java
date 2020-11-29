package com.berezanskyi.booking.services;

import com.berezanskyi.booking.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user) throws IllegalAccessException; // а от нічого воно і не throws

    void editUser(String login, User editUser);

    @Transactional // я б інтерфейсі не заявляв яке воно, трансакшионал чи ні, це деталі реалізації
    void deleteUserByLogin(String login);

    Optional<User> findUserByLogin(String login);

    List<User> getAllUsers();
}
