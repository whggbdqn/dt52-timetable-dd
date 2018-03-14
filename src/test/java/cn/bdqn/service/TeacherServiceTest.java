/**
 * Project Name:app
 * File Name:TeacherServiceTest.java
 * Package Name:cn.bdqn.service
 * Date:2018年3月1日上午11:58:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bdqn.pojo.Teacher;

/**
 * Description:   <br/>
 * Date:     2018年3月1日 上午11:58:15 <br/>
 * @author   junwen.bao
 * @version
 * @see
 */
public class TeacherServiceTest extends BaseTest{

    private final static Logger log = LoggerFactory.getLogger(TeacherServiceTest.class);
    @Autowired
    private TeacherService teacherService;
    @Test
    public void testGetAllTeacher() {
        log.info("run:{}","进入测试方法");
        List<Teacher> list = this.teacherService.getAllTeacher();
        Assert.assertNotNull(list);        
    }

}

