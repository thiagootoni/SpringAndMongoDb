package com.thiago.postsApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.postsApi.models.dto.UserDto;
import com.thiago.postsApi.models.entities.User;
import com.thiago.postsApi.respositories.UserRepository;
import com.thiago.postsApi.services.exceptions.ElementNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<UserDto> findAll(){
		List<User> users = this.repository.findAll();
		return users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
	}

	public UserDto findById(String id) {
		
		User user = this.repository.findById(id)
				.orElseThrow(() -> new ElementNotFoundException("Elemento não encontrado"));
		
		return new UserDto(user);
	}

}
