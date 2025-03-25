package com.architecture.service.impl;

import com.architecture.dto.request.CreateUserDto;
import com.architecture.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.architecture.repository.UserRepository;
import com.architecture.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserEntity createUser(CreateUserDto createUserDto) {
        UserEntity user = UserEntity.builder()
                .name(createUserDto.name())
                .email(createUserDto.email())
                .password(createUserDto.password())
                .build();

        return this.userRepository.save(user);
    }
}
