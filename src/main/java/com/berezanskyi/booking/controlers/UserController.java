package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.converter.UserConverter;
import com.berezanskyi.booking.converter.UserDtoConverter;
import com.berezanskyi.booking.dtos.CreateUserDto;
import com.berezanskyi.booking.dtos.UserDto;
import com.berezanskyi.booking.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserServices userServices;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDtoConverter userDtoConverter;


    @PostMapping
    public boolean createUser(@RequestBody CreateUserDto createUserDto){
        return userServices.createUser(userConverter.convert(createUserDto));
    }

    @PatchMapping("/{login}")
    public boolean editUser(@PathVariable String login, @RequestBody Map<String, String> userFieldsToEdit)  {
        return userServices.editUser(login, userFieldsToEdit);
    }

    @DeleteMapping("/{login}")
    public boolean deleteUserByLogin(@PathVariable String login) {
        return userServices.deleteUserByLogin(login);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userDtoConverter.convertAll(userServices.getAllUsers());
    }

}



