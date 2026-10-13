package com.example.exp3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message = "Please enter a username")
    @Size(min = 3, max = 20, message = "Please enter a valid name")
    private String username;

    @NotBlank(message = "Please enter an email")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Please enter a password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}