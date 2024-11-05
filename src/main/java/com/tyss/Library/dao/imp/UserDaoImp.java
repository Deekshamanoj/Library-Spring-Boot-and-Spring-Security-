package com.tyss.Library.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.Library.dao.UserDao;
import com.tyss.Library.entity.User;
import com.tyss.Library.repository.UserRepository;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private UserRepository userRepository ;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
