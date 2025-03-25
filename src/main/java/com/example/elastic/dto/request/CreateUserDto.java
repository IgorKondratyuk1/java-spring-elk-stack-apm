package com.example.elastic.dto.request;

public record CreateUserDto(
        String name,
        String email,
        String password
) {}
