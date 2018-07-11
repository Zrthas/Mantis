package com.zrthas.springboot;

import com.zrthas.springboot.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //获取YML文件的参数
    @Value("${score}")
    private Integer score;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    @RequestMapping(value = "/getBaseParam",method = RequestMethod.GET)
    public String getBaseParam(){
        return content;
    }

    @Autowired
    private StudentEntity studentEntity;

    @RequestMapping(value = "/getEntityParam",method = RequestMethod.GET)
    public String getEntityParam(){
        return studentEntity.getName();
    }
}
