package com.example.elastic.service;



import com.example.elastic.dto.request.CreateUserDto;
import com.example.elastic.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity createUser(CreateUserDto user);
}
