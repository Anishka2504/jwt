package com.example.authorizationservice.service;

import com.example.authorizationservice.dto.UserCreationDto;
import com.example.authorizationservice.dto.UserDto;
import com.example.authorizationservice.entity.User;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto create(UserCreationDto userDto);

    UserDto update(Long id, UserDto userDto);

    void delete(Long id);

}
