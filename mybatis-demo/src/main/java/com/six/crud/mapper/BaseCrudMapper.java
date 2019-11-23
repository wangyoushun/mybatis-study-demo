package com.six.crud.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BaseCrudMapper<T> {

    int selectCount(@Param("condition") T condition, @Param("exMap") Map<String, Object> exMap);
}
