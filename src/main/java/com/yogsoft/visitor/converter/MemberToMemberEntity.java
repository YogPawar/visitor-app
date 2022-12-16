package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.Member;
import com.yogsoft.visitor.entity.AddressEntity;
import com.yogsoft.visitor.entity.MemberEntity;

@Component
public class MemberToMemberEntity implements Converter<Member, MemberEntity> {

	@Override
	public MemberEntity convert(Member source) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setMemberId(source.getMemberId());
		memberEntity.setFirstName(source.getFirstName());
		memberEntity.setLastName(source.getLastName());
		memberEntity.setOwner(source.isOwner());
		memberEntity.setPhotoPath(source.getPhotoPath());
		memberEntity.setAddress(getAddress(source));
		return memberEntity;
	}

	private AddressEntity getAddress(Member source) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setRoomNo(source.getRoomNo());
		addressEntity.setFloor(source.getFloor());
		addressEntity.setWing(source.getWing());
		return addressEntity;
	}

}
