package com.berezanskyi.booking.controlers;

import com.berezanskyi.booking.converter.UserConverter;
import com.berezanskyi.booking.converter.UserDtoConverter;
import com.berezanskyi.booking.dtos.CreateUpdateUserDto;
import com.berezanskyi.booking.dtos.UserDto;
import com.berezanskyi.booking.services.iml.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DefaultUserService defaultUserService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDtoConverter userDtoConverter;


    @PostMapping
    public void createUser(@RequestBody CreateUpdateUserDto createUpdateUserDto) {
        defaultUserService.createUser(userConverter.convert(createUpdateUserDto));
    }

    @PutMapping("/{login}")
    public void editUser(@PathVariable String login, @RequestBody CreateUpdateUserDto createUpdateUserDto) {
        defaultUserService.editUser(login, userConverter.convert(createUpdateUserDto));
    }

    @DeleteMapping("/{login}")
    public void deleteUserByLogin(@PathVariable String login) {
        defaultUserService.deleteUserByLogin(login);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userDtoConverter.convertAll(defaultUserService.getAllUsers());
    }


}



