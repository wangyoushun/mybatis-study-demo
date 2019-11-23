package com.six.crud.mapper;

import com.six.crud.entity.DemoLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface DemoLogMapper extends BaseCrudMapper<DemoLog>{
    int deleteByPrimaryKey(Long id);

    int insert(DemoLog record);

    int insertSelective(DemoLog record);

    DemoLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoLog record);

    int updateByPrimaryKey(DemoLog record);

    int batchInsert(@Param("list") List<DemoLog> list);

    List<DemoLog> queryPage(RowBounds rowBounds);

    List<DemoLog> queryPage();

    int countTotal();

    int selectCount(@Param("condition") DemoLog condition, @Param("exMap") Map<String, Object> exMap);
}