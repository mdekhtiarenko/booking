package com.berezanskyi.booking.services;


import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MyBeanUntil myBeanUntil;



    public boolean createUser(User user){
        if (userIsPresent(user.getLogin())){
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    @Transactional
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public boolean deleteUserByLogin(String login) {
        if (userIsPresent(login)) {
            userRepository.deleteByLogin(login);
            return true;
        } else {
            return false;
        }
    }

    public boolean editUser(String login, Map<String, String> userFieldsToEdit) {
        Optional<User> userOptional = userRepository.findByLogin(login);

        if (userOptional.isPresent()) {
            User userWithEditsFields = objectMapper.convertValue(userFieldsToEdit, User.class);
            User userEdits = userOptional.get();
            try {
                myBeanUntil.copyProperties(userEdits, userWithEditsFields);
                userRepository.save(userEdits);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean userIsPresent(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

}
