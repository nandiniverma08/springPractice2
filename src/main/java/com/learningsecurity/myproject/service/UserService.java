package com.learningsecurity.myproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learningsecurity.myproject.entity.MyUser;
import com.learningsecurity.myproject.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
		System.out.println("UserName...."+username);
		MyUser user=userRepository.findByUserName(username);
		System.out.println("User...."+user.toString());

		if(username.equals(user.getUserName())) {
			return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		}
		catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		
		
	}

}
