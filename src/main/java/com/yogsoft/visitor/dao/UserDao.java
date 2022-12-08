package com.yogsoft.visitor.dao;

import java.util.List;

import com.yogsoft.visitor.entity.UserEntity;

public interface UserDao {

	public List<UserEntity> getUsers();

	public void saveUser(UserEntity theUser);

	public UserEntity getUser(int theId);

	public void deleteUser(int theId);

}
