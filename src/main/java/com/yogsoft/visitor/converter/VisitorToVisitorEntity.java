package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.Visitor;
import com.yogsoft.visitor.entity.VisitorEntity;

@Component
public class VisitorToVisitorEntity implements Converter<Visitor, VisitorEntity> {

	@Override
	public VisitorEntity convert(Visitor source) {
		VisitorEntity visitorEntity = new VisitorEntity();
		visitorEntity.setVisitorId(source.getVisitorId());
		visitorEntity.setVisitorName(source.getName());
		visitorEntity.setPurpose(source.getPurpose());
		visitorEntity.setInTime(source.getInTime());
		visitorEntity.setOutTime(source.getOutTime());
		visitorEntity.setVisitDate(source.getVisitDate());
		visitorEntity.setOwnerId(source.getMemberId());
		visitorEntity.setContactNo(source.getContatNumber());

		return visitorEntity;
	}

}
