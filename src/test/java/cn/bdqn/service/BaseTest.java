/**
 * Project Name:app
 * File Name:BaseTest.java
 * Package Name:cn.bdqn.service
 * Date:2018年3月1日上午11:58:40
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:   <br/>
 * Date:     2018年3月1日 上午11:58:40 <br/>
 * @author   junwen.bao
 * @version
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-mybatis.xml","/applicationContext-service.xml"})
public abstract class BaseTest {

}

