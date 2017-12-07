package com.bsl.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bsl.entity.User;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter@Setter
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	public List<User> byNameAndPass(User user){
		
		String sql = "select u from User u where u.name=?1 and u.pass=?2";
		Session session = sessionFactory.openSession();
		List<User> list = session.createQuery(sql).setString(1, user.getName())
							.setString(2, user.getPass()).list();
//		List<User> list=(List<User>) session.createSQLQuery(sql).addEntity("u",User.class);
		session.close();
		return list;
		
		
	}
	
}
