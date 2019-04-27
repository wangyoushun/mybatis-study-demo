package com.six.crud.testaction;

import com.six.crud.entity.DemoClassroom;
import com.six.crud.entity.DemoLog;
import com.six.crud.entity.DemoStudent;
import com.six.crud.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CurdAction {
    public static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    private SqlSession sqlSession;

    // see http://www.mybatis.org/mybatis-3/zh/sqlmap-xml.html#Result_Maps
    @Test
    public void oneToMany02(){
        DemoClassroomMapper demoClassroomMapper = sqlSession.getMapper(DemoClassroomMapper.class);
        List<DemoClassroom> rooms = demoClassroomMapper.queryClassAndStudent02();
        for (DemoClassroom room : rooms) {
            System.out.println(room.getName());
            List<DemoStudent> students = room.getStudents();
            for (DemoStudent student : students) {
                System.out.println(room.getName()+";  "+student);
            }
        }
    }

    //see http://www.mybatis.org/mybatis-3/zh/sqlmap-xml.html#Result_Maps
    @Test
    public void oneToMany01(){
        DemoClassroomMapper demoClassroomMapper = sqlSession.getMapper(DemoClassroomMapper.class);
        List<DemoClassroom> rooms = demoClassroomMapper.queryClassAndStudent();
        for (DemoClassroom room : rooms) {
            System.out.println(room.getName());
            List<DemoStudent> students = room.getStudents();
            for (DemoStudent student : students) {
                System.out.println(room.getName()+";  "+student);
            }
        }
    }

    @Test
    public void queryTest(){
        final DemoLogMapper mapper = sqlSession.getMapper(DemoLogMapper.class);
        DemoLog demoLog = mapper.selectByPrimaryKey(1L);
        System.out.println(demoLog);
    }

    @Test
    public void insertClassroomAndStudent(){
        DemoClassroomMapper demoClassroomMapper = sqlSession.getMapper(DemoClassroomMapper.class);
        DemoClassroom demoClassroom = new DemoClassroom();
        demoClassroom.setId(3L);
        demoClassroom.setName("上海3中");
        demoClassroom.setAddress("上海青浦区");
        demoClassroom.setCreator("wys");
        demoClassroom.setModifier("wys");
        Date date = new Date();
        demoClassroom.setGmtCreated(date);
        demoClassroom.setGmtModified(date);
        demoClassroomMapper.insertSelective(demoClassroom);
        System.out.println(demoClassroom);

        DemoStudentMapper studentMapper = sqlSession.getMapper(DemoStudentMapper.class);
        for (int i = 0; i < 3; i++) {
            DemoStudent demoStudent = new DemoStudent();
            demoStudent.setName("stu"+i);
            demoStudent.setNumber(UUID.randomUUID().toString());
            demoStudent.setAge(i*2);
            demoStudent.setClassId(3L);
            demoStudent.setSex("M");
            demoStudent.setGmtCreated(date);
            demoStudent.setGmtModified(date);
            studentMapper.insertSelective(demoStudent);
        }
        sqlSession.commit();
    }

    @Before
    public void getSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession=build.openSession();
    }

}
