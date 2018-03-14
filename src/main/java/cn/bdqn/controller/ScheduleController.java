package cn.bdqn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.converter.Schedule2ClassTime4Week;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.ClassesService;
import cn.bdqn.service.ScheduleService;
import cn.bdqn.service.TeacherService;
import cn.bdqn.vo.ClassTime4day;

@Controller
public class ScheduleController {
    
    private final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private ScheduleService scheService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassesService classesService;
    
/**
 * 得到老师所有授课班级的集合
 * @Description 
 * @param teacher
 * @return List<Classes>
 * @throws Exception
 */
    @RequestMapping("/myClassList")
    @ResponseBody
    public List<Classes> getAllClassesByTeacherId(Teacher teacher) throws Exception {
        
        // 根据emplid获取teacher
        teacher = teacherService.getTeacher(teacher);
        
        // 根据teacherid获取classes
        Classes classes = new Classes();
        classes.setTeacherId(teacher.getTeacherId());
        
        List<Classes> classeslist = classesService.getAllClassesByTeacherId(classes);
        
        return classeslist;
    }

    
    /**
     * 查看我一周的课表
     * @Description
     * @param teacher
     * @return
     * @throws Exception
     */
    
    @RequestMapping("/mySchedule")
    @ResponseBody
    public List<ClassTime4day> getScheduleByTeacher(Teacher teacher) throws Exception {
//        logger.info(teacher.toString());
//        System.out.println(teacher);
        
//        通过name或emplid获取teacher(第一次登陆前emplid为空，需存入表中)
        teacher = teacherService.getTeacher(teacher);
        
//        System.out.println(teacher);
//        logger.info("teacher{}",teacher);
        
        Schedule schedule = new Schedule();
        schedule.setTeacherId(teacher.getTeacherId());
        
//        根据老师钉钉id查询出课表信息
        List<Schedule> list = scheService.getSchedules(schedule);

//        System.out.println(list);

        // 将课程集合转换班次集合
        return new Schedule2ClassTime4Week().convert(list);
    }

    /**
     * 根据老师所授课班级id查看课表
     * @Description
     * @param teacher
     * @return List<ClassTime4day>
     * @throws Exception
     */
    @RequestMapping("/myClassSchedule")
    @ResponseBody
    public List<ClassTime4day> getScheduleByClass(Classes classes) throws Exception {
        
        Schedule schedule = new Schedule();
//        System.out.println(classes.getClassPk());
        schedule.setClassesId(classes.getClassPk());
        List<Schedule> list = scheService.getSchedules(schedule );

        // 将课程集合转换班次集合
        return new Schedule2ClassTime4Week().convert(list);
    }
}
