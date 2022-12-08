package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.User;
import com.yogsoft.visitor.entity.UserEntity;

@Component
public class UserEntitytoUser implements Converter<UserEntity, User> {

	@Override
	public User convert(UserEntity source) {
		User user = new User();
		user.setUserId(source.getUserId());
		user.setContatNumber(source.getContactNumber());
		user.setFirstName(source.getFirstName());
		user.setUserName(source.getUserName());
		user.setLastName(source.getLastName());
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		return user;
	}

}
