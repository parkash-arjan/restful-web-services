package com.fibonacci.rs.restfulwebservices.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fibonacci.rs.restfulwebservices.bean.User;
import com.fibonacci.rs.restfulwebservices.dao.UserDAO;
import com.fibonacci.rs.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDAO dao;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User findUser(@PathVariable Long id) {
		User user = dao.findOne(id);
		if (user == null) {

			throw new UserNotFoundException(String.format("User with id %s not found", id));
		}
		return user;
	}

	@DeleteMapping(path = "/users/{id}")
	public User deleteUserById(@PathVariable Long id) {
		User user = dao.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException(String.format("User with id %s not found", id));
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveduser = dao.save(user);
		// HTTP STATUS CREATED
		// RETURN URI

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
