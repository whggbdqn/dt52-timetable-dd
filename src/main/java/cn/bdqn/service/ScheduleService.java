package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Schedule;


public interface ScheduleService {
    /**
     * 
     * @Description (根据班级或老师id 和当前时间查询本周课表)
     * @param schedule
     * @return
     */
    List<Schedule> getSchedules(Schedule schedule) throws Exception;
    
    /**
     * @Description (根据课程主键获取课时信息)
     * @param schedule
     * @return
     */
    Schedule getScheduleBySchedulePk(Schedule schedule);

    
    /**
     * @Description (根据课程主键修改课程信息)
     * @param schedule
     * @return
     */
	int updateSchedule(Schedule schedule);
    
}
