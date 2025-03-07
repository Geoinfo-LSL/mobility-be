package com.example.simulation.users.dto;

import com.example.simulation.users.domain.UsersEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@RequiredArgsConstructor
public class CustomUserDetail implements UserDetails {
    private UsersEntity usersEntity;

    public CustomUserDetail(UsersEntity usersEntity) {this.usersEntity = usersEntity;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return usersEntity.getUsername();
    }

    public String getUserId() {
        return usersEntity.getUserId();
    }
}
