package com.smartblogger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.smartblogger.model.User;

public class UserDAO implements DaoImpl<User, String> {

	public UserDAO() {
	}

	public void openCurrentSessionwithTransaction() {
		HibernateUtil.openCurrentSessionwithTransaction();
	}
	
	public void closeCurrentSessionwithTransaction() {
		HibernateUtil.closeCurrentSessionwithTransaction();
	}
	
	public void openCurrentSession() {
		HibernateUtil.currentSession();
		
	}
	
	public void closeCurrentSession() {
		HibernateUtil.closeSession();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		List<User> users = (List<User>) HibernateUtil.currentSession().createQuery("from User").list();
		return users;
	}
	
	public User getById(String id) {
		User user = (User) HibernateUtil.currentSession().get(User.class, Integer.valueOf(id));
		return user; 
	}
	
	public void create(User user) {
		HibernateUtil.currentSession().save(user);
	}

	public void update(User user) {
		HibernateUtil.currentSession().update(user);
	}

	

	public User getByUsername(String username) {
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("name", username)).uniqueResult();
		return user; 
	}

	public boolean isValidPassword(String username, String password) {
		boolean result = false;
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("name", username)).uniqueResult();
		if (user != null &&   password.equals(user.getPassword())) {
			
			result = true;
		}
		return result;
	}
	
	public void delete(User user) {
		HibernateUtil.currentSession().delete(user);
	}

	public void deleteAll() {
		List<User> userList = getAll();
		for (User user : userList) {
			delete(user);
		}
	}

}
