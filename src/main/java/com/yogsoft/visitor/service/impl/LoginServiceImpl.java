package com.yogsoft.visitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogsoft.visitor.bean.Login;
import com.yogsoft.visitor.dao.LoginDao;
import com.yogsoft.visitor.entity.UserEntity;
import com.yogsoft.visitor.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public String login(Login login) {
		UserEntity user = loginDao.login(login.getUserName(), login.getPassword());
		if (user != null) {
			return "menu";
		}
		return (user != null) ? "menu" : "login";
	}

}
