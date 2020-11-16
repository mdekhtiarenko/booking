package com.berezanskyi.booking.services.iml;


import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.exeption.MyException;
import com.berezanskyi.booking.repositories.UserRepository;
import com.berezanskyi.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user)  {
        if (findUserByLogin(user.getLogin()).isPresent()){
            throw new MyException("User with login " + user.getLogin() + " already exists", HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
    }

    @Override
    public void editUser(String login, User editUser) {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new MyException("User with login " + login + " does not exists", HttpStatus.NOT_FOUND));
        editUser.setId(user.getId());
        userRepository.save(editUser);
    }

    @Override
    @Transactional
    public void deleteUserByLogin(String login) {
        if (!userRepository.findByLogin(login).isPresent()){
            throw new MyException("User with login " + login + " does not exists", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteByLogin(login);
    }


    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
