package com.example.mybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.bean.User;
import com.example.mybatisplusdemo.jvmext.JavaClassExecuter;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class CurdController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/list")
    public List<User> list(){
//        return userMapper.selectList(null);
        return sqlSession.selectList("com.six.crud.mapper.UserMapper.selectByxml");
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

    //动态加载class文件
    @RequestMapping("/loadClass")
    public String loadClass(@RequestParam("file") MultipartFile file) throws Exception {
        InputStream is = file.getInputStream();
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        return JavaClassExecuter.execute(b);
    }

}
