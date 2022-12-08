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
import com.yogsoft.visitor.dao.VisitorDao;
import com.yogsoft.visitor.entity.MemberEntity;
import com.yogsoft.visitor.entity.VisitorEntity;

@Repository
public class VisitorDaoImpl implements VisitorDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	MemberDao memberDao;

	static Logger logger = Logger.getLogger(VisitorDaoImpl.class);

	@Override
	@Transactional
	public void saveVisitor(VisitorEntity visitor, int memberId) {
		MemberEntity memberEntity = memberDao.getMember(memberId);
		if (memberEntity.getAddress() != null) {
			visitor.setAddressEntity(memberEntity.getAddress());
		}
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(visitor);

	}

	@Override
	@Transactional
	public void deleteVisitor(int theId) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("Delete visitor : " + theId);
		session.delete(getVisitor(theId));

	}

	@Override
	@Transactional
	public VisitorEntity getVisitor(int theId) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("Get visitor : " + theId);

		return session.get(VisitorEntity.class, theId);
	}

	@Override
	@Transactional
	public List<VisitorEntity> getVisitors() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<VisitorEntity> cq = cb.createQuery(VisitorEntity.class);
		Root<VisitorEntity> root = cq.from(VisitorEntity.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

}
