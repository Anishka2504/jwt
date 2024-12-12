package com.example.authorizationservice.entity;

import com.example.authorizationservice.entity.parent.BaseNameLogEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Base64;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseNameLogEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    private String login;

    @Column(name = "password_hash", unique = true)
    private String password;

    private String email;

    private String phone;

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"),
    foreignKey = @ForeignKey(name = "fk_user_to_role"))
    private Set<Role> roleSet;
}
