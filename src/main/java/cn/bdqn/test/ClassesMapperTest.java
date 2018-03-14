package cn.bdqn.test;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Teacher;


public class ClassesMapperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAllClassesById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        ClassesMapper mapper = context.getBean(ClassesMapper.class);
        Classes classes = new Classes();
        classes.setClassPk(1);
        classes.setInstructorId(4);
//        classes.setTeacherId(5);
        List<Classes> list = mapper.getAllClassesByTeacherId(classes );
        assertNull(list.get(0));
    }

    @Test
    public void testGetAllClassesByTeacherId(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        ClassesMapper mapper = context.getBean(ClassesMapper.class);
//        TeacherMapper teacherMapper = new TeacherMapper();
//        Teacher teacher = new Teacher();
//        teacher.setEmplId("manager533");
//        teacherMapper.getTeacher(teacher);
    }
}
