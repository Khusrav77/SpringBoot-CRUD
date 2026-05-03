package com.shh.crud.service;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.dto.UserResponseDto;
import com.shh.crud.exception.UserNotFoundException;
import com.shh.crud.repository.UserRepository;
import com.shh.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.shh.crud.service.UserMapper.toDto;
import static com.shh.crud.service.UserMapper.toEntity;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {
        User user = toEntity(requestDto);
        return toDto(userRepo.save(user));
    }

    @Override
    public UserResponseDto get(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found"));
        return toDto(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
       return userRepo.findAll()
               .stream()
               .map(UserMapper::toDto)
               .toList();
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto newUser) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found"));

        user.setName(newUser.getName());
        user.setAge(newUser.getAge());
        return toDto(userRepo.save(user));
    }

    @Override
    public void delete(Long id) {
        if(!userRepo.existsById(id)) {
           throw  new UserNotFoundException("User with id " + id + " not found");
        }
        userRepo.deleteById(id);
    }
}
