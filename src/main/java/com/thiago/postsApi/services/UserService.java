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
		
		User user = getUserById(id);
		return new UserDto(user);
	}

	public UserDto insertOne(UserDto userDto) {
		
		User user = new User();
		copyDtoToEntity(userDto, user);
		this.repository.insert(user);
		return new UserDto(user);
	}
	
	public UserDto updateOne(UserDto userDto, String id) {
		
		User user = getUserById(id);		
		copyDtoToEntity(userDto, user);		
		this.repository.save(user);
		return new UserDto(user);	
		
	}

	private void copyDtoToEntity(UserDto userDto, User user) {
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());		
	}
	
	private User getUserById(String id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ElementNotFoundException("Elemento não encontrado"));
	}

}
