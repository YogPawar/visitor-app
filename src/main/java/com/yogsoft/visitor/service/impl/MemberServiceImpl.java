package com.yogsoft.visitor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.yogsoft.visitor.bean.Member;
import com.yogsoft.visitor.dao.MemberDao;
import com.yogsoft.visitor.entity.MemberEntity;
import com.yogsoft.visitor.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private ConversionService conversionService;

	@Override
	public List<Member> getMembers() {

		return memberDao.getMembers().stream().map(member -> conversionService.convert(member, Member.class))
				.collect(Collectors.toList());
	}

	@Override
	public void saveMember(Member theMember) {
		memberDao.saveMember(conversionService.convert(theMember, MemberEntity.class));

	}

	@Override
	public Member getMember(int theId) {
		return conversionService.convert(memberDao.getMember(theId), Member.class);
	}

	@Override
	public void deleteMember(int theId) {
		memberDao.deleteMember(theId);

	}

}
