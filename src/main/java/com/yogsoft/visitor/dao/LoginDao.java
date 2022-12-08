package com.yogsoft.visitor.dao;

import com.yogsoft.visitor.entity.UserEntity;

public interface LoginDao {
	public UserEntity login(String username, String password);

}
