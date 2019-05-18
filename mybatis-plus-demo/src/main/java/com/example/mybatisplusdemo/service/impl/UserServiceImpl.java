package com.example.mybatisplusdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.bean.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> pageList() {
		for (int i = 0; i < 10; i++) {
			IPage<User> userIPage2 = userMapper.selectPage(new Page<>(i + 1, 2), null);
			List<User> records2 = userIPage2.getRecords();
			System.out.println(records2);
		}
		return null;
	}

}
