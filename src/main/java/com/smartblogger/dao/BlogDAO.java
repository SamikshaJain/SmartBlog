package com.smartblogger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;
import com.smartblogger.dao.HibernateUtil;

public class BlogDAO implements DaoImpl< Blog, String> {


	public BlogDAO() {
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
	
	
	public void closeCurrentSessionOnException() {
		HibernateUtil.closeSessionOnException();
		
	}
	
	public void closeCurrentSession() {
		HibernateUtil.closeSession();
		
	}
	@SuppressWarnings("unchecked")
	public List<Blog> getAll() {
		List<Blog> Blog = (List<Blog>) HibernateUtil.currentSession().createQuery("from Blog").list();
		return Blog;
	}

	@SuppressWarnings("unchecked")
	public List<Blog> getBlogInRange(Integer first, Integer count) {
		Query tmp = HibernateUtil.currentSession().createQuery("from Blog");

	    if (first != null)
	        tmp.setFirstResult(first);
	    if (count != null)
	        tmp.setMaxResults(count);

	    return (List<Blog>)tmp.list();
	}
	
		
		/*
		List<Blog> Blog = (List<Blog>) HibernateUtil.currentSession().createQuery("from Blog").list();
		return Blog;*/

	
	public Blog getById(Integer id) {
		Blog Blog = (Blog) HibernateUtil.currentSession().get(Blog.class, id);
		return Blog; 
	}
	
	public void create(Blog blog) {
		HibernateUtil.currentSession().save(blog);
	}

	public void update(Blog blog) {
		HibernateUtil.currentSession().update(blog);
	}

	
	
	public void delete(Blog blog) {
		HibernateUtil.currentSession().delete(blog);
	}

	
	public void deleteAll() {
		List<Blog> blogList = getAll();
		for (Blog blog : blogList) {
			delete(blog);
		}
	}

	public Blog getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


