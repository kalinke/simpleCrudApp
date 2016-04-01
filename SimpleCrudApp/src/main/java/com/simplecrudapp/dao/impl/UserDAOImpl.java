package com.simplecrudapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.simplecrudapp.dao.AbstractDAO;
import com.simplecrudapp.dao.UserDAO;
import com.simplecrudapp.domain.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	public User save(User user) {
		return save(user);
	};

    public void updateUser(User user){
    	update(user);
    }

    public User findById(Integer id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}
}
