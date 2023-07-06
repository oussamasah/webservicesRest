package com.webservices.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webservices.demo.api.model.User;

@Service
public class UserService {

	private List<User> userList;

	public UserService() {
		userList = new ArrayList<>();

		User user1 = new User(1, "oussama", 28, "osahraoui70@gmail.com");
		User user2 = new User(2, "thamer", 26, "thamer@gmail.com");
		User user3 = new User(3, "tekup", 28, "tekup@gmail.com");
		User user4 = new User(4, "soap", 22, "soap@gmail.com");
		User user5 = new User(5, "rest", 28, "rest@gmail.com");
		userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

	}

	public List<User> selectAll() {
		return userList;
	}

	
	public boolean addUser(User newStudent) 
	{
		
		 int lastIndex = userList.size() - 1;
	     User lastUser = userList.get(lastIndex);
		newStudent.setId(lastUser.getId() + 1);
		return userList.add(newStudent);
	}
	
	public User getUser(int id) {
		
		return userList.stream().filter(x-> x.getId() == id).collect(Collectors.toList()).get(0);
	}

	public List<User> getByName(String name) {
		return userList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).toList();
	}

	public void deleteUser(int id) {
		userList.removeIf(x -> x.getId() == id);
	}
}
