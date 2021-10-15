package com.xiexin.springtest;

import com.xiexin.service.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class) //@autuwrid可以用
@SpringBootTest //证明 可以启动boot
@EnableAutoConfiguration //开启 配置
public class StudentTest {
    @Autowired
    private StudentsService studentsService;
    @Test
    public void selectMore(){
        Map map=new HashMap();
        map.put("jiaoSeName","学生");
        List<Map> maps = studentsService.selectMore1(map);
        System.out.println("maps = " + maps);
        for (Map map1 : maps) {
            System.out.println("map1.get(\"studentName\") = " + map1.get("studentName"));
        }
    }
}
