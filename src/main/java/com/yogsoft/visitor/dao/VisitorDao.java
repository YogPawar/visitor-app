package com.yogsoft.visitor.dao;

import java.util.List;

import com.yogsoft.visitor.entity.VisitorEntity;

public interface VisitorDao {

	public void saveVisitor(VisitorEntity visitor, int memeberId);

	public void deleteVisitor(int theId);

	public VisitorEntity getVisitor(int theId);

	public List<VisitorEntity> getVisitors();

}
