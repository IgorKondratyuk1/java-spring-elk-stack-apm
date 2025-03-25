package com.example.elastic.util.mapper;


import com.example.elastic.dto.response.ViewUserDto;
import com.example.elastic.entity.UserEntity;

import java.util.List;

public class UserMapper {
    public static ViewUserDto mapEntityToView(UserEntity user) {
        return new ViewUserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static List<ViewUserDto> mapEntityListToViewList(List<UserEntity> userEntityList) {
        return userEntityList.stream()
                .map(user -> mapEntityToView(user))
                .toList();
    }
}
