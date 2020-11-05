package com.berezanskyi.booking.services;


import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public boolean editUser(String login, User user){
        Optional<User> userOptional = userRepository.findByLogin(login);

        if (userOptional.isPresent()){
            user.setId(userOptional.get().getId());
            userRepository.save(user);
            return true;
        } else {
            return false;
        }

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    private boolean userIsPresent(String login){
        return userRepository.findByLogin(login).isPresent();
    }




}
