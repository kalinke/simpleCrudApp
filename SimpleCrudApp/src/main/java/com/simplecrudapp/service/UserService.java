package com.simplecrudapp.service;
	
import java.util.List;

import com.simplecrudapp.domain.User;

public interface UserService {
	
	public User save(User user);
	
	public User getById(Integer id);
	
	public List<User> listUsers();
}
