package com.shh.crud.service;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);
    UserResponseDto get(Long id);
    List<UserResponseDto> getAll();
    UserResponseDto update(Long id, UserRequestDto newUser);
    void delete(Long id);
}
