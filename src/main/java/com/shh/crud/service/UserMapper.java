package com.shh.crud.service;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.dto.UserResponseDto;
import com.shh.crud.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDto requestDto) {
        return new User(requestDto.getName(), requestDto.getAge());
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getAge());
    }
}
