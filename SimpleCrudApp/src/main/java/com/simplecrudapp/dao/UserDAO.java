package com.simplecrudapp.dao;

import java.util.List;

import com.simplecrudapp.domain.User;

public interface UserDAO{

	public User save(User user);
	
	public User findById(Integer id);

	public List<User> list();
}
