package com.javainuse.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private String userName;
	private String password;
	private String email;
	private String mobilePhoneNumber;
}