package com.six.crud.mapper;

import com.six.crud.dto.PageDTO;
import com.six.crud.entity.DemoStudent;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DemoStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DemoStudent record);

    int insertSelective(DemoStudent record);

    DemoStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoStudent record);

    int updateByPrimaryKey(DemoStudent record);

    List<DemoStudent> queryPage(RowBounds rowBounds);

    List<DemoStudent> queryPage();

    List<DemoStudent> queryPage(PageDTO pageDTO);
}