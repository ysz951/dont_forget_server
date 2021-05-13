package com.dont.forget.payload;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpRequest {


    @NotNull
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;


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

}
