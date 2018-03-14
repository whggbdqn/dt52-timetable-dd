package cn.bdqn.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.TeacherService;


public class TeacherServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetTeacher() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml","applicationContext-service.xml");
        TeacherService service = context.getBean(TeacherService.class);
        Teacher teacher = new Teacher();
//        teacher.setTeacherId(2);
        teacher.setEmplId("manager533");
        teacher = service.getTeacher(teacher);
        assertNull(teacher);
    }

}
