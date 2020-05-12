package com.javainuse.model.dto;

import com.javainuse.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String userName;
    private String password;
    private String email;
    private String mobilePhoneNumber;

    public UserResponse(User user) {
        userName = user.getUserName();
        password = user.getPassword();
        email = user.getEmail();
        mobilePhoneNumber = user.getMobilePhoneNumber();
    }
}