package com.tyss.Library.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyss.Library.dao.UserDao;
import com.tyss.Library.dto.ResponseStructure;
import com.tyss.Library.entity.User;
import com.tyss.Library.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao ;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		responseStructure.setData(userDao.saveUser(user));
		responseStructure.setMessage(HttpStatus.CREATED.name());
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}

}
