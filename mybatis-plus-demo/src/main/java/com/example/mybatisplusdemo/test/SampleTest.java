package com.example.mybatisplusdemo.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplusdemo.bean.MybatisDemoLog;
import com.example.mybatisplusdemo.bean.User;
import com.example.mybatisplusdemo.mapper.MybatisDemoLogMapper;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MybatisDemoLogMapper mybatisDemoLogMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


    @Test
    public void testRunGCode(){
        List<MybatisDemoLog> mybatisDemoLogs = mybatisDemoLogMapper.selectList(new LambdaQueryWrapper<MybatisDemoLog>().gt(MybatisDemoLog::getId, 3));
        mybatisDemoLogs.forEach(System.out::println);

    }



}