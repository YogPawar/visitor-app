package com.yogsoft.visitor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.yogsoft.visitor.bean.User;
import com.yogsoft.visitor.dao.UserDao;
import com.yogsoft.visitor.entity.UserEntity;
import com.yogsoft.visitor.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		return userDao.getUsers().stream().map(user -> conversionService.convert(user, User.class))
				.collect(Collectors.toList());
	}

	@Override
	public void saveUser(User theUser) {
		userDao.saveUser(conversionService.convert(theUser, UserEntity.class));

	}

	@Override
	public User getUser(int theId) {
		return conversionService.convert(userDao.getUser(theId), User.class);
	}

	@Override
	public void deleteUser(int theId) {
		userDao.deleteUser(theId);

	}

}
