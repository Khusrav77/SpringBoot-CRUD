package com.shh.crud.controller;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.dto.UserResponseDto;
import com.shh.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
            return userService.create(userRequestDto);
    }

    @GetMapping("{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
