package com.tecno_comfenalco.pa.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tecno_comfenalco.pa.security.model.UserModel;

public class CustomUserDetails implements UserDetails {
    private UserModel userEntity;

    public CustomUserDetails(UserModel userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return userEntity.isEnabled();
    }

    public String getUserId() {
        return userEntity.getId();
    }

}
