package com.simplecrudapp.service;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecrudapp.dao.UserDAO;
import com.simplecrudapp.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userRepository;
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public User getById(Integer id){
		return userRepository.findById(id);
	}
	
	public List<User> listUsers(){
		return userRepository.list();
	}
}
