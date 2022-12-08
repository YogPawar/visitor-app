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

import com.yogsoft.visitor.dao.MemberDao;
import com.yogsoft.visitor.entity.MemberEntity;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	static Logger logger = Logger.getLogger(MemberDaoImpl.class);


	@Override
	@Transactional
	public List<MemberEntity> getMembers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<MemberEntity> cq = cb.createQuery(MemberEntity.class);
		Root<MemberEntity> root = cq.from(MemberEntity.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveMember(MemberEntity theMember) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theMember);

	}

	@Override
	@Transactional
	public MemberEntity getMember(int theId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(MemberEntity.class, theId);
	}

	@Override
	@Transactional
	public void deleteMember(int theId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getMember(theId));
	}

}
