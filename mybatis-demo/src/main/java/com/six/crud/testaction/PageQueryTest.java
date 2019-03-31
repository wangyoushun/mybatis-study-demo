package com.six.crud.testaction;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.crud.dto.PageDTO;
import com.six.crud.entity.DemoLog;
import com.six.crud.entity.DemoStudent;
import com.six.crud.mapper.DemoLogMapper;
import com.six.crud.mapper.DemoStudentMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PageQueryTest extends BaseAction{
    @Test
    public void testPageByPageInfo(){
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();

        final DemoLogMapper mapper = sqlSession.getMapper(DemoLogMapper.class);
        for (int i = 50; i < 100; i++) {
            Page<DemoLog> demoStudents = PageHelper.startPage(i, 20).doSelectPage(() -> mapper.queryPage());
            System.out.println("i= "+i+", "+demoStudents);
        }

        Console.log("insertData100w = {}", timeInterval.intervalMs());
    }


    @Test
    public void testPageByRowbounds(){
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();

        final DemoLogMapper mapper = sqlSession.getMapper(DemoLogMapper.class);
        for (int i = 50; i < 100; i++) {
            System.out.println(mapper.countTotal());
            List<DemoLog> demoStudents = mapper.queryPage(new RowBounds(i*20, 20));
            System.out.println("i= "+i+", "+demoStudents);
        }

        Console.log("insertData100w = {}", timeInterval.intervalMs());
    }



    @Test
    public void pageByRowbounds(){
        DemoStudentMapper studentMapper = sqlSession.getMapper(DemoStudentMapper.class);
        RowBounds rowBounds = new RowBounds(1, 5);
        List<DemoStudent> demoStudents = studentMapper.queryPage(rowBounds);
        for (DemoStudent demoStudent : demoStudents) {
            System.out.println(demoStudent);
        }
    }

    @Test
    public void pageByPageHelper(){
        final DemoStudentMapper studentMapper = sqlSession.getMapper(DemoStudentMapper.class);
        Page<DemoStudent> demoStudents = PageHelper.startPage(1, 5).doSelectPage(() -> studentMapper.queryPage());
        System.out.println(demoStudents.getResult());
        for (DemoStudent demoStudent : demoStudents) {
            System.out.println(demoStudent);
        }
    }

    //<property name="supportMethodsArguments" value="true"/>
    @Test
    public void testPageByPojoParameters(){
        final DemoStudentMapper studentMapper = sqlSession.getMapper(DemoStudentMapper.class);
        PageDTO pageDTO = PageDTO.builder().pageNum(1).pageSize(5).build();
        List<DemoStudent> demoStudents = studentMapper.queryPage(pageDTO);
        demoStudents.forEach(System.out::println);

    }
}
