package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ScheduleMapper;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.service.ScheduleService;
import cn.bdqn.util.WeekUtil;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    private ScheduleMapper mapper;
    
    @Override
    public List<Schedule> getSchedules(Schedule schedule)  throws Exception{
        String monday = WeekUtil.getMonday();
        String sunday = WeekUtil.getSunday();
        
        schedule.setFirstDay(monday);
        schedule.setEndDay(sunday);
        List<Schedule> list = mapper.getSchedules(schedule);
        return list;
    }

	@Override
	public Schedule getScheduleBySchedulePk(Schedule schedule) {
		return mapper.getScheduleBySchedulePk(schedule);
	}

	@Override
	public int updateSchedule(Schedule schedule) {
		return mapper.updateSchedule(schedule);
	}



}
