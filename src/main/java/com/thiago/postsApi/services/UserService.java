package com.thiago.postsApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.postsApi.models.dto.UserDto;
import com.thiago.postsApi.models.entities.User;
import com.thiago.postsApi.respositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<UserDto> findAll(){
		List<User> users = this.repository.findAll();
		return users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
	}

}
