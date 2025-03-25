package com.architecture.dto.request;

public record CreateUserDto(
        String name,
        String email,
        String password
) {}
