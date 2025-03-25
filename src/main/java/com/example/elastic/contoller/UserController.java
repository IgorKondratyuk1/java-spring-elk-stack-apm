package com.architecture.contoller;

import com.architecture.dto.request.CreateUserDto;
import com.architecture.dto.response.ViewUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.architecture.service.UserService;
import com.architecture.util.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ViewUserDto> getAllUsers() {
        return UserMapper.mapEntityListToViewList(this.userService.getAllUsers());
    }

    @PostMapping
    public ViewUserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return UserMapper.mapEntityToView(this.userService.createUser(createUserDto));
    }
}
