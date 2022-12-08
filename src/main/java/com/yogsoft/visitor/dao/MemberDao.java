package com.yogsoft.visitor.dao;

import java.util.List;

import com.yogsoft.visitor.entity.MemberEntity;

public interface MemberDao {
	public List<MemberEntity> getMembers();

	public void saveMember(MemberEntity theUser);

	public MemberEntity getMember(int theId);

	public void deleteMember(int theId);

}
