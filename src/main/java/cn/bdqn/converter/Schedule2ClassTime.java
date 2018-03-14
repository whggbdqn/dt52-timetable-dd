package cn.bdqn.converter;

import cn.bdqn.enums.Period;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.vo.ClassTime;
/**
 * 
 * @ClassName Schedule2ClassTime
 * @Description 将持久层对象转换成显示层对象
 * @author yw
 * @Date 2018年2月3日 下午8:26:00
 * @version 1.0.0
 */
public class Schedule2ClassTime implements ConverterPojo<Schedule,ClassTime>{

    @Override
    public ClassTime convert(Schedule schedule) throws Exception{
        ClassTime classTime = new ClassTime();
//      将课程教师放入到班次中  
        classTime.setTeacherName(schedule.getTeacher().getName());
//      将课程日期放入到班次中  
        classTime.setSchDate(schedule.getSchDate());
        
        classTime.setSchedulePk(schedule.getSchedulePk());
//        将班级名放入班次中
        classTime.setClassName(schedule.getClasses().getClassName());
//        将班级所占的机房放入班次中
        classTime.setRoomName(schedule.getRoom().getRoomName());
//        将课时信息放入班次中
        classTime.setCourseContent(schedule.getCourse().getCourseContent());
        
        String st = schedule.getSchTime();
        switch (st) {
        case "AM":
            classTime.setPeroid(Period.AM);
            break;
        case "PM":
            classTime.setPeroid(Period.PM);
            break;
        case "EM":
            classTime.setPeroid(Period.EM);
            break;            
        default:
            break;
        }
        
        return classTime;
    }

}
