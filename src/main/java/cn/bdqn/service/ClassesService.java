package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Classes;


public interface ClassesService{
    List<Classes> getClassesById(int id) throws Exception;
    
    List<Classes> getAllClasses();
    
    List<Classes> getAllClassesByTeacherId(Classes classes) throws Exception;//获取teacher所有的班级
}
