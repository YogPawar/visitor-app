package com.yogsoft.visitor.dao.impl;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogsoft.visitor.dao.LoginDao;
import com.yogsoft.visitor.entity.UserEntity;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	static Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Override
	public UserEntity login(String username, String password) {
		UserEntity user;
		try {
			Session session = sessionFactory.openSession();
			TypedQuery<UserEntity> tyQuery = session.getNamedQuery("findByUserName");
			tyQuery.setParameter("userName", username);
			tyQuery.setParameter("password", password);
			user = tyQuery.getSingleResult();
			logger.info("User " + username + " logged in sucessfully");
			return (user != null) ? user : null;
		} catch (Exception ecException) {
			ecException.printStackTrace();
			return null;
		}

	}

}
