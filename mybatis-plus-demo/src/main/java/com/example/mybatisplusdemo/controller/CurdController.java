package com.example.mybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.bean.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurdController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> list(){
        return userMapper.selectList(null);
    }

    @RequestMapping("/crud")
    public void crud(){
        User user = new User();
        userMapper.insert(user);

        user.setName("aaa");
        userMapper.updateById(user);

        User user1 = userMapper.selectById(user.getId());
        System.out.println(user1);

        List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("name", "Sandy"));
        System.out.println(users);

        List<User> users2 = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getName, "Sandy"));
        System.out.println(users2);

        List<User> users3 = userMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getName, "Sandy"));
        users3.forEach(System.out::println);

        userMapper.deleteById(user.getId());
    }

    @RequestMapping("/createData")
    public void createData(){
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("bob"+i);
            user.setAge(i);
            user.setEmail("e"+i);
            userMapper.insert(user);
        }
    }

    @RequestMapping("/page")
    public List<User> page(){
        IPage<User> userIPage = userMapper.selectPage(new Page<>(1, 8), null);
        List<User> records = userIPage.getRecords();

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .select("name", "age")
                .gt("age", 21);
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

}
