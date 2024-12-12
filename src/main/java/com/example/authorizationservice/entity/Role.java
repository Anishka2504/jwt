package com.example.authorizationservice.entity;

import com.example.authorizationservice.entity.parent.BaseNameEntity;
import com.example.authorizationservice.entity.parent.BaseNameLogEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role extends BaseNameEntity implements GrantedAuthority {

    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.LAZY)
    private List<User> userList;

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Role role = (Role) obj;
        return getId().equals(role.getId()) && getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 31 * hash + getId().intValue();
        hash = 31 * hash + (getName() == null ? 0 : getName().hashCode());
        return hash;
    }


}
