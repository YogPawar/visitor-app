package com.yogsoft.visitor.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogsoft.visitor.dao.UserDao;
import com.yogsoft.visitor.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	@Transactional
	public List<UserEntity> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
		Root<UserEntity> root = cq.from(UserEntity.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		logger.debug("List of User ");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveUser(UserEntity theUser) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theUser);

	}

	@Override
	@Transactional
	public UserEntity getUser(int theId) {
		logger.info("Get user details  of User : " + theId);
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserEntity.class, theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		logger.info("Delete user : " + theId);
		Session session = sessionFactory.getCurrentSession();
		UserEntity userEntity = getUser(theId);
		session.delete(userEntity);

	}

}
