package com.learningsecurity.myproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningsecurity.myproject.dto.LoginDTO;
import com.learningsecurity.myproject.dto.RegisterDTO;
import com.learningsecurity.myproject.entity.MyUser;
import com.learningsecurity.myproject.entity.Post;
import com.learningsecurity.myproject.repository.UserRepository;
import com.learningsecurity.myproject.service.UserService;
import com.learningsecurity.myproject.util.JwtUtil;

@RestController
public class HomeController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO login) throws Exception {
		System.out.println("Inside Login API"+login.toString());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
		}
		catch(UsernameNotFoundException exp){
			exp.printStackTrace();
			throw new Exception("Bad Credential");
		}
		final UserDetails userDetails = userService.loadUserByUsername(login.getUserName());

		final String token = jwtUtil.generateToken(userDetails);
		return token;
		
	}
	@PostMapping("/register")
	public String register(@RequestBody RegisterDTO register) {
		System.out.println("Register Data to be Saved"+register.toString());
		MyUser myUser = new MyUser();
		myUser.setUserName(register.getUserName());
		myUser.setPassword(register.getPassword());
		userRepository.save(myUser);
		
		return "User register successfully";
	}
}
