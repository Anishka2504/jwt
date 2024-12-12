package com.example.authorizationservice.dto;

import jakarta.persistence.Column;

public class UserCreationDto {

    private String name;

    private String lastName;

    private String middleName;

    private String login;

    private String password;

    private String email;

    private String phone;

    private String dateCreation;

    private String lastModified;

    private int version;

}
