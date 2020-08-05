package com.user.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.LockMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.UserDetails;
@Repository
@Transactional
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	ObjectMapper mapper=new ObjectMapper();
	
	@SuppressWarnings("unchecked")
	public List<UserDetails> getUsers(){
		String hql="from UserDetails";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> details=q.list();
		return details;
	}
	
	public UserDetails getUserByID(int id){
		String hql="from UserDetails where UserID=:id";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("id", id);
		return (UserDetails) q.uniqueResult();
	}
	
	public UserDetails getUser(){
		String hql="from UserDetails where UserID=:id";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("id", 2);
		return (UserDetails) q.uniqueResult();
	}

}
