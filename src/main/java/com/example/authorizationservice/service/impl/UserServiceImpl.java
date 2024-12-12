package com.example.authorizationservice.service.impl;

import com.example.authorizationservice.converter.UserConverter;
import com.example.authorizationservice.dto.UserCreationDto;
import com.example.authorizationservice.dto.UserDto;
import com.example.authorizationservice.entity.User;
import com.example.authorizationservice.repository.UserRepository;
import com.example.authorizationservice.security.jwt.JwtUserFactory;
import com.example.authorizationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private UserConverter converter;
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDto findById(Long id) {
        return ;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto create(UserCreationDto userDto) {
        return null;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = converter.toDto(userRepository.findUserByLogin(username));
        return JwtUserFactory.createJwtUser(converter.dtoToModel(userDto));
    }
}
