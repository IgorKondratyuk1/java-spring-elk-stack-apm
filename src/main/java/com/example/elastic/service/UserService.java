package com.architecture.service;

import com.architecture.dto.request.CreateUserDto;
import com.architecture.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity createUser(CreateUserDto user);
}
