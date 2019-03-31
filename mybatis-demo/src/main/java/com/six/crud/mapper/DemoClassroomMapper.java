package com.six.crud.mapper;

import com.six.crud.entity.DemoClassroom;

import java.util.List;

public interface DemoClassroomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DemoClassroom record);

    int insertSelective(DemoClassroom record);

    DemoClassroom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoClassroom record);

    int updateByPrimaryKey(DemoClassroom record);

    List<DemoClassroom> queryClassAndStudent();

    List<DemoClassroom> queryClassAndStudent02();
}