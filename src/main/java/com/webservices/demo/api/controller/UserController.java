package com.webservices.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.demo.api.model.User;
import com.webservices.demo.services.UserService;

@RestController
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService uservice) {
		this.userService = uservice;
	}

	@GetMapping("/user")
	public List<User> getAll() {
		return userService.selectAll();
	}

	@PostMapping("/user")
	public List<User> addUser(@RequestBody User newUser) {
		userService.addUser(newUser);
		return userService.selectAll();
	}

	@GetMapping("/user/{id}")
	public User getuser(@PathVariable int id) {
		return userService.getUser(id);

	}
	@GetMapping("/user/search/{name}")
	public List<User> getuserbyName(@PathVariable String name) {
		return userService.getByName(name);

	}

	@DeleteMapping("user/{id}")
	public List<User> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return userService.selectAll();
	}
}
