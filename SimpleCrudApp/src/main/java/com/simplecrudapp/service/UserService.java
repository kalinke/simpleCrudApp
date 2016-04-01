package com.simplecrudapp.service;
	
import java.util.List;

import com.simplecrudapp.domain.User;

public interface UserService {
	
	Integer save(User user);
	
	User getById(Integer id);
	
	List<User> listUsers();

	void update(User user);

	void delete(User user);
}
