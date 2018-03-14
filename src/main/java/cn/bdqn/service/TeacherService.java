package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Teacher;

public interface TeacherService {
    
    Teacher getTeacher(Teacher teacher) throws Exception;
    
    int updateEmplId(Teacher teacher) throws Exception;

	List<Teacher> getAllTeacher();

}
