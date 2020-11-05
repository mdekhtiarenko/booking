package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserServices userServices;


    @DeleteMapping("/delete/{login}")
    public boolean deleteUserByLogin1(@PathVariable String login) {
        return userServices.deleteUserByLogin(login);
    }


}
