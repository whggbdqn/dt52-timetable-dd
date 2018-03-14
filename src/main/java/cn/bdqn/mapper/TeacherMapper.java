package cn.bdqn.mapper;

import java.util.List;

import cn.bdqn.pojo.Teacher;



public interface TeacherMapper {
    /**
     * 可以根据老师id、name、钉钉emplid信息得到对象
     * @Description
     * @param teacher
     * @return
     * @throws Exception
     */
    Teacher getTeacher(Teacher teacher) throws Exception;
    
    int updateEmplId(Teacher teacher) throws Exception;

	List<Teacher> getAllTeacher();
    

}