package cn.bdqn.converter;

import java.util.ArrayList;
import java.util.List;

import cn.bdqn.pojo.Schedule;
import cn.bdqn.util.WeekUtil;
import cn.bdqn.vo.ClassTime;
import cn.bdqn.vo.ClassTime4day;

/**
 * 
 * @ClassName Schedule2ClassTime4Week
 * @Description 一周的课表
 * @author yw
 * @Date 2018年2月4日 下午4:32:31
 * @version 1.0.0
 */
public class Schedule2ClassTime4Week implements ConverterList<Schedule, ClassTime4day> {
/**
 * 将List<Schedule>转换成List<ClassTime4day>
 * @throws Exception 
 */
    @Override
    public List<ClassTime4day> convert(List<Schedule> list) throws Exception {
//       定义一个7天的班次集合
        List<ClassTime4day> result = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            result.add(new ClassTime4day());
        }
        Schedule2ClassTime convertor = new Schedule2ClassTime();
        
        for (Schedule schedule : list) {
//            将PO转换为VO
            ClassTime ct = convertor.convert(schedule);
//            通过日期得到周几的index（以周日下标为0）
            int day = WeekUtil.getWeekDay(schedule.getSchDate())-1;
//            根据周次（对应的星期几）的索引获取班次
            ClassTime4day ctd = result.get(day);
      
//            注意在jsp页面要进行判断 ctd是否为空，存在休息和无课
            
//            将班次信息放入一天的班级课程对象中
            ctd.setClassTime(ct.getPeroid().ordinal(), ct);
//            班次日期
            ctd.setCurDate(schedule.getSchDate());
            
        }
//        将周日移到最后
        ClassTime4day classTime4day = result.get(0);
        
        result.remove(0);
        
        result.add(6, classTime4day);
        return result;
    }

}
