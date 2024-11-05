package com.tyss.Library.service;

import org.springframework.http.ResponseEntity;

import com.tyss.Library.dto.ResponseStructure;
import com.tyss.Library.entity.User;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);
	
	
}
