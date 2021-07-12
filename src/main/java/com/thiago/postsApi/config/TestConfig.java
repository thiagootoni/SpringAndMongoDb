package com.thiago.postsApi.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thiago.postsApi.models.entities.User;
import com.thiago.postsApi.respositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init() {
		
		userRepo.deleteAll();
		
		User maria = new User(null, "Maria Bron", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User dave = new User(null, "Dave New", "dave@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria, alex, dave));
	}

}
