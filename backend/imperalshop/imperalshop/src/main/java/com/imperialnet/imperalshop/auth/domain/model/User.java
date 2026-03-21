package com.imperialnet.imperalshop.auth.domain.model;

import com.imperialnet.imperalshop.auth.domain.service.ValidateUserService;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;
    private Role role;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;



    private User(Builder builder){

        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
        this.status = builder.status;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.lastLoginAt = builder.lastLoginAt;
    }


    public static class Builder{
        private Long id;
        private String email;
        private String password;
        private Role role;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime lastLoginAt;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            ValidateUserService.validateEmail(email);
            return this;
        }
        public Builder password(String password){
            this.password = password;
            ValidateUserService.validatePassword(password);
            return this;
        }
        public Builder role(Role role){
            this.role = role;
            ValidateUserService.validateRole(role);
            return this;
        }
        public Builder status(Status status){
            this.status = status;
            ValidateUserService.validateStatus(status);
            return this;
        }
        public Builder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }
        public Builder updatedAt(LocalDateTime updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder lastLoginAt(LocalDateTime lastLoginAt){
            this.lastLoginAt = lastLoginAt;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

}
