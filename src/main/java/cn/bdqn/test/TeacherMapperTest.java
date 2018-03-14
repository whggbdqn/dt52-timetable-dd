package cn.bdqn.test;

import static org.junit.Assert.*;

import javax.security.auth.x500.X500Principal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Teacher;


public class TeacherMapperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetTeacher() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        TeacherMapper mapper = context.getBean(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTeacherId(2);
        teacher = mapper.getTeacher(teacher);
        assertNull(teacher);
    }

}
