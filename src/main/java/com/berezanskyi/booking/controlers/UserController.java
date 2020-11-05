package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.converter.UserConverter;
import com.berezanskyi.booking.converter.UserDtoConverter;
import com.berezanskyi.booking.dtos.CreateUserDto;
import com.berezanskyi.booking.dtos.UserDto;
import com.berezanskyi.booking.entity.User;
import com.berezanskyi.booking.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserServices userServices;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDtoConverter userDtoConverter;

    @PutMapping("/edit/{login}")
    public boolean editUser(@PathVariable String login, @RequestBody CreateUserDto createUserDto){
        return userServices.editUser(login, userConverter.convert(createUserDto));
    }

    @DeleteMapping("/delete/{login}")
    public boolean deleteUserByLogin(@PathVariable String login) {
        return userServices.deleteUserByLogin(login);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userDtoConverter.convertAll(userServices.getAllUsers());
    }



}
