package com.example.authorizationservice.security.jwt;

import com.example.authorizationservice.entity.Role;
import com.example.authorizationservice.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public static JwtUser createJwtUser(User user) {
        return JwtUser.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .name(user.getName())
                .username(user.getLogin())
                .password(user.getPassword())
                .grantedAuthorities(user.getRoleSet())
                .email(user.getEmail())
                .phone(user.getPhone())

                .build();
    }
}
