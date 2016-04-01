package com.simplecrudapp.dao;

import java.util.List;

import com.simplecrudapp.domain.User;

public interface UserDAO{

	Integer save(User user);
	
	User findById(Integer id);

	List<User> list();
	
	void update(User user);

	void delete(User user);
}
