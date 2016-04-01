package com.simplecrudapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrudapp.domain.User;
import com.simplecrudapp.service.UserService;

@RestController
@RequestMapping("/beer")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			user = service.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> list() {
		return service.listUsers();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		try {
			User beer = service.getById(id);
			return ResponseEntity.ok(beer);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
