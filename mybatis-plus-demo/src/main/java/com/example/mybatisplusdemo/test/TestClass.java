package com.example.mybatisplusdemo.test;

import com.example.mybatisplusdemo.bean.User;
import com.example.mybatisplusdemo.jvmext.ApplicationContextHelper;
import com.example.mybatisplusdemo.mapper.UserMapper;

import java.util.List;

public class TestClass {
    public void loadHotCode(String[] args) {
        System.out.println("aaa bbb");

        UserMapper userMapper = (UserMapper) ApplicationContextHelper.getBean("userMapper");
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

        User user = new User();
        user.setName("aaabbbbcc");
        user.setAge(12);
        user.setEmail("e2323");
        userMapper.insert(user);
        System.out.println(userMapper.selectList(null));
    }
}
