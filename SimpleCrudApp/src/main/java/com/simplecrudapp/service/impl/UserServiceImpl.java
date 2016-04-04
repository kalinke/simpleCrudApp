package com.simplecrudapp.service.impl;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplecrudapp.dao.UserDAO;
import com.simplecrudapp.domain.User;
import com.simplecrudapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public Integer save(User user){
		return userDAO.save(user);
	}
	
	public User getById(Integer id){
		return userDAO.findById(id);
	}
	
	public List<User> listUsers(){
		return userDAO.list();
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
