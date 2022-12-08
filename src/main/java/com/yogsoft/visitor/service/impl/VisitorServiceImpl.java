package com.yogsoft.visitor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.yogsoft.visitor.bean.Visitor;
import com.yogsoft.visitor.dao.VisitorDao;
import com.yogsoft.visitor.entity.VisitorEntity;
import com.yogsoft.visitor.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorDao visitorDao;

	@Autowired
	private ConversionService conversionService;

	@Override
	public void saveVisitor(Visitor visitor) {

		visitorDao.saveVisitor(conversionService.convert(visitor, VisitorEntity.class), visitor.getMemberId());

	}

	@Override
	public void deleteVisitor(int theId) {
		visitorDao.deleteVisitor(theId);

	}

	@Override
	public Visitor getVisitor(int theId) {
		return conversionService.convert(visitorDao.getVisitor(theId), Visitor.class);
	}

	@Override
	public List<Visitor> getVisitors() {
		return visitorDao.getVisitors().stream().map(visitor -> conversionService.convert(visitor, Visitor.class))
				.collect(Collectors.toList());
	}

}
