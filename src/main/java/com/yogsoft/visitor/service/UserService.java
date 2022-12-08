package com.yogsoft.visitor.service;

import java.util.List;

import com.yogsoft.visitor.bean.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

}
