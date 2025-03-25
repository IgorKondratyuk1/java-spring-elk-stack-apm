package com.example.elastic.service.impl;


import co.elastic.apm.api.CaptureSpan;
import co.elastic.apm.api.CaptureTransaction;
import com.example.elastic.dto.request.CreateUserDto;
import com.example.elastic.entity.UserEntity;
import com.example.elastic.repository.UserRepository;
import com.example.elastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    @CaptureSpan(value = "createUser")
    public UserEntity createUser(CreateUserDto createUserDto) {
        boolean isValid = validateData(createUserDto);
        System.out.println("Is name of user valid ?: " + isValid);

        UserEntity user = UserEntity.builder()
                .name(createUserDto.name())
                .email(createUserDto.email())
                .password(createUserDto.password())
                .build();

        return this.userRepository.save(user);
    }

    @CaptureSpan(value = "validateData")
    public boolean validateData(CreateUserDto createUserDto) {
        return createUserDto.name().length() > 1;
    }
}
