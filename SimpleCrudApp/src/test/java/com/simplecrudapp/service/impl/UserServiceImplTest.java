package com.simplecrudapp.service.impl;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.simplecrudapp.dao.UserDAO;
import com.simplecrudapp.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {


	
	@Mock
	private UserDAO userDAO;
	
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void initializate(){
		userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserDAO(userDAO);
	}	
	
	@Test
	public void shouldSaveUser(){
		//Given
		User user = givenUser(1);
		
		//When
		when(userDAO.save(user)).thenReturn(1);
		Integer userId = userServiceImpl.save(user);
	
		//Then
		assertNotNull(userId);
		assertEquals(1, userId.intValue());
	}
	
	@Test
	public void shouldGetUserById(){
		//Given
		User user = givenUser(1);
		
		//When
		when(userDAO.findById(1)).thenReturn(user);
		User testUser = userServiceImpl.getById(1);

		//Then
		assertNotNull(testUser);
		assertEquals("name", testUser.getName());
		assertEquals("address", testUser.getAddress());
	}
	
	@Test
	public void shouldUpdateUser(){
		//Given
		User user = givenUser(1);
		
		//When
		userServiceImpl.update(user);
		
		//Then
		verify(userDAO, times(1)).update(user);
		verifyNoMoreInteractions(userDAO);
	}

	@Test
	public void shouldDeleteUser(){
		//Given
		User user = givenUser(1);
		
		//When
		userServiceImpl.delete(user);
		
		//Then
		verify(userDAO, times(1)).delete(user);
		verifyNoMoreInteractions(userDAO);
	}
	
	@Test
	public void shouldListUsers(){
		//Given
		List<User> users = Arrays.asList(givenUser(1), givenUser(2));
		
		//When
		when(userDAO.list()).thenReturn(users);
		List<User> testUsers = userServiceImpl.listUsers();
		
		//Then
		assertNotNull(testUsers);
		assertEquals(2, testUsers.size());
	}

	private User givenUser(Integer id) {
		User user = new User();
		user.setId(id);
		user.setName("name");
		user.setBirth(new Date());
		user.setAddress("address");
		user.setEmail("email");
		return user;
	}
}
