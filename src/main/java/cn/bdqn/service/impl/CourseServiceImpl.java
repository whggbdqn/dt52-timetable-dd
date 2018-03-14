package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.CourseMapper;
import cn.bdqn.pojo.Course;
import cn.bdqn.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper course;
	
	@Override
	public List<Course> getAllCourse() {
		return course.getAllCourse();
	}

}
