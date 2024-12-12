package com.example.authorizationservice.converter;
import com.example.authorizationservice.converter.uses.DateTimeMapper;
import com.example.authorizationservice.dto.UserCreationDto;
import com.example.authorizationservice.dto.UserDto;
import com.example.authorizationservice.entity.User;
import com.example.authorizationservice.security.jwt.JwtUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface UserConverter {

    User dtoToModel(UserDto userDto);

    User dtoToModel(UserCreationDto userCreationDto);

    UserDto toDto(User user);

    @Mapping(source = "roleSet", target = "grantedAuthorities")
    JwtUser toJwtUser(User user);

    @Mapping(source = "grantedAuthorities", target = "roleSet")
    User toUser(JwtUser jwtUser);
}
