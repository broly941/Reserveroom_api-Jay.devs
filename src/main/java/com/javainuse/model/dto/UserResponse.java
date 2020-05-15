package com.javainuse.model.dto;

import com.javainuse.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String mobilePhoneNumber;

    public UserResponse(User user) {
        userId = user.getId();
        userName = user.getUserName();
        email = user.getEmail();
        mobilePhoneNumber = user.getMobilePhoneNumber();
    }
}