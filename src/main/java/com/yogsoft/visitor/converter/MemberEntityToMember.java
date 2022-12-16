package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.Member;
import com.yogsoft.visitor.entity.MemberEntity;

@Component
public class MemberEntityToMember implements Converter<MemberEntity, Member> {

	@Override
	public Member convert(MemberEntity source) {
		Member member = new Member();
		member.setMemberId(source.getMemberId());
		member.setFirstName(source.getFirstName());
		member.setLastName(source.getLastName());
		member.setOwner(source.isOwner());
		member.setFloor(source.getAddress().getFloor());
		member.setRoomNo(source.getAddress().getRoomNo());
		member.setWing(source.getAddress().getWing());
		member.setAddressId(source.getAddress().getAddressId());
		member.setPhotoPath(source.getPhotoPath());

		return member;
	}

}
