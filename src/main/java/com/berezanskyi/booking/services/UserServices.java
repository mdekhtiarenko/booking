package com.berezanskyi.booking.services;


import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Optional<User> findUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Transactional
    public boolean deleteUserByLogin(String login){
        if (findUserByLogin(login).isPresent()){
            userRepository.deleteByLogin(login);
            return true;
        } else {
            return false;
        }
    }
}
