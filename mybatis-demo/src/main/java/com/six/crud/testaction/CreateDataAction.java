package com.six.crud.testaction;


import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import com.six.crud.entity.DemoLog;
import com.six.crud.mapper.DemoLogMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateDataAction extends BaseAction{
    @Test
    public void insertData01(){
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        // insert 10w data

        DemoLogMapper mapper = sqlSession.getMapper(DemoLogMapper.class);
        for (int i = 0; i < 100000; i++) {
            DemoLog demoLog = new DemoLog();
            demoLog.setuId(UUID.randomUUID().toString());
            demoLog.setOptType("01");
            mapper.insertSelective(demoLog);
        }
        sqlSession.commit();


        Console.log("insertData100w = {}", timeInterval.intervalMs());
    }


    @Test
    public void testInsert02() {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        // insert 10w data

        DemoLogMapper mapper = batchSqlSession.getMapper(DemoLogMapper.class);
        for (int i = 0; i < 100000; i++) {
            DemoLog demoLog = new DemoLog();
            demoLog.setuId(UUID.randomUUID().toString());
            demoLog.setOptType("01");
            mapper.insertSelective(demoLog);
            if(i % 1000 == 0){
                batchSqlSession.flushStatements();
            }
        }
        batchSqlSession.flushStatements();
        batchSqlSession.commit();

        Console.log("insertData100w = {}", timeInterval.intervalMs());
    }


    //最快
    @Test
    public void testInsert03() {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        // insert 10w data

        DemoLogMapper mapper = batchSqlSession.getMapper(DemoLogMapper.class);
        List<DemoLog> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            DemoLog demoLog = new DemoLog();
            demoLog.setuId(UUID.randomUUID().toString());
            demoLog.setOptType("01");
            list.add(demoLog);

            if(list.size() % 100 ==0){
                mapper.batchInsert(list);
                list.clear();
            }

            if(i % 1000 == 0){
                batchSqlSession.flushStatements();
            }
        }
        if(list.size()>0){
            mapper.batchInsert(list);
        }
        batchSqlSession.flushStatements();
        batchSqlSession.commit();

        Console.log("insertData100w = {}", timeInterval.intervalMs());
    }
}
