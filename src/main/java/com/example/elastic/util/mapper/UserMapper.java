package com.architecture.util.mapper;

import com.architecture.dto.response.ViewUserDto;
import com.architecture.entity.UserEntity;

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
