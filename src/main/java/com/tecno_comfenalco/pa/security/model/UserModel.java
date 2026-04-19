package com.tecno_comfenalco.pa.security.model;

import java.util.Set;
import java.util.UUID;

public class UserModel {
    private String id;
    private String username;
    private String password;
    private boolean enabled;
    private Set<String> roles;

    public UserModel() {
    }

    public static UserModel createDraft(String username, String password, Set<String> roles, boolean enabled) {
        return UserModel.builder()
                .id(UUID.randomUUID().toString())
                .username(username)
                .password(password)
                .roles(roles)
                .enabled(enabled)
                .build();
    }

    private UserModel(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.enabled = builder.enabled;
        this.roles = builder.roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String username;
        private String password;
        private boolean enabled;
        private Set<String> roles;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}
