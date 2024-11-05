package com.tyss.Library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tyss.Library.entity.User;
import com.tyss.Library.exception.InvaildCredentialsException;
import com.tyss.Library.repository.UserRepository;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user!=null)
			return new ApplicationUserDetails(user);
		throw new InvaildCredentialsException("Invalid email and password" + username);
	}

}
