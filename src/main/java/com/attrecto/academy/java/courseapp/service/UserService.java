package com.attrecto.academy.java.courseapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;
import java.util.List;

@Service
public class UserService {
	private MinimalUserDto firstUser;
	private MinimalUserDto secondUser;
	
public List<MinimalUserDto> listAllUsers() {
		return new ArrayList<>(Arrays.asList(firstUser, secondUser));
	}

	public MinimalUserDto getUserById(Integer id) {
		return firstUser;
	}

	public MinimalUserDto createUser(Integer id, MinimalUserDto createUserDto) {
		MinimalUserDto newUserDto = new MinimalUserDto();
		newUserDto.setId(id);
		newUserDto.setName("user" + id);
		newUserDto.setEmail(String.format("user%semail@attrecto.com", id));
		return newUserDto;
	}

	public MinimalUserDto updateUser(Integer id, MinimalUserDto updateUserDto) {
		MinimalUserDto updatedUserDto = new MinimalUserDto();
		updatedUserDto.setId(id);
		updatedUserDto.setName("user" + id);
		updatedUserDto.setEmail(String.format("user%semail@attrecto.com", id));
		return updatedUserDto;
	}

	public void deleteUser(Integer id) {
		
	}
	}