package com.yogsoft.visitor.service;

import java.util.List;

import com.yogsoft.visitor.bean.Member;

public interface MemberService {

	public List<Member> getMembers();

	public void saveMember(Member theMember);

	public Member getMember(int theId);

	public void deleteMember(int theId);

}
