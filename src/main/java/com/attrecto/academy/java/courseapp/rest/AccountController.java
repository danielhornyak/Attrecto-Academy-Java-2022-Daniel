package com.attrecto.academy.java.courseapp.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attrecto.academy.java.courseapp.model.dto.LoginDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;
import com.attrecto.academy.java.courseapp.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/account")
@Tag(name = "Account API")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
    @GetMapping(value= "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Give back information about the logged user" ,security = {@SecurityRequirement(name = "token")})
	public MinimalUserDto me() {
		return accountService.getLoggedUser();
	}
	
    @PostMapping(value= "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a login token")
	public String login(@RequestBody LoginDto loginDto) {
		return accountService.generateJwtToken(loginDto);
	}
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List all users" ,security = {@SecurityRequirement(name = "token")})
    public List<MinimalUserDto> getAllUser() {
    	return accountService.listAllUsers();
    }
    
    @GetMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a user by id" ,security = {@SecurityRequirement(name = "token")})
    public MinimalUserDto getUserById(@PathVariable final Integer id) {
    	return accountService.getUserById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a new user" ,security = {@SecurityRequirement(name = "token")})
    public MinimalUserDto createUser(@Valid @RequestBody MinimalUserDto createUserDto) {
    	return accountService.createUser(7, createUserDto);
    }
    
    @PutMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an existing user" ,security = {@SecurityRequirement(name = "token")})
    public MinimalUserDto updateCourse(@PathVariable final Integer id, @Valid @RequestBody MinimalUserDto createUserDto) {
    	return accountService.updateUser(id, createUserDto);
    }    
    
    @DeleteMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete an existing user" ,security = {@SecurityRequirement(name = "token")})
    public void deleteCourse(@PathVariable final Integer id) {
    	accountService.deleteUser(id);
    }
}
