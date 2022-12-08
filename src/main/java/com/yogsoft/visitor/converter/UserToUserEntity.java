package com.yogsoft.visitor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.yogsoft.visitor.bean.User;
import com.yogsoft.visitor.entity.UserEntity;

@Component
public class UserToUserEntity implements Converter<User, UserEntity> {

	@Override
	public UserEntity convert(User source) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(source.getUserId());
		userEntity.setContactNumber(source.getContatNumber());
		userEntity.setFirstName(source.getFirstName());
		userEntity.setUserName(source.getUserName());
		userEntity.setLastName(source.getLastName());
		userEntity.setEmail(source.getEmail());
		userEntity.setPassword(source.getPassword());
		return userEntity;
	}

}
