package com.yogsoft.visitor.service;

import java.util.List;

import com.yogsoft.visitor.bean.Visitor;

public interface VisitorService {

	public void saveVisitor(Visitor visitor);

	public void deleteVisitor(int theId);

	public Visitor getVisitor(int theId);

	public List<Visitor> getVisitors();

}
