package com.soft863.service.serviceImpl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft863.entity.User;
import com.soft863.mapper.LoginMapper;
import com.soft863.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Resource
	LoginMapper loginMapper;
	@Override
	public User login(User u) throws Exception {
		User user = loginMapper.logi(u);
		return user;
	}

}

