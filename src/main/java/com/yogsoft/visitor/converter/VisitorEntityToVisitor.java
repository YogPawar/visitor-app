package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.Visitor;
import com.yogsoft.visitor.entity.VisitorEntity;

@Component
public class VisitorEntityToVisitor implements Converter<VisitorEntity, Visitor> {

	@Override
	public Visitor convert(VisitorEntity source) {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(source.getVisitorId());
		visitor.setName(source.getVisitorName());
		visitor.setPurpose(source.getPurpose());
		if (source.getInTime() != null) {
			visitor.setInTime(source.getInTime());
		}
		if (source.getOutTime() != null) {
			visitor.setOutTime(source.getOutTime());
		}
		visitor.setFloor(source.getAddressEntity().getFloor());
		visitor.setWing(source.getAddressEntity().getWing());
		visitor.setRoomNo(source.getAddressEntity().getRoomNo());
		visitor.setVisitDate(source.getVisitDate());
		visitor.setMemberId(source.getOwnerId());
		visitor.setContatNumber(source.getContactNo());
		return visitor;
	}

}
