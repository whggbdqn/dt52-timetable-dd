package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.pojo.Classes;
import cn.bdqn.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classes;


	@Override
	public List<Classes> getClassesById(int id) {
		return null;
	}

	@Override
	public List<Classes> getAllClasses() {
		return classes.getAllClasses();
	}

    @Override
    public List<Classes> getAllClassesByTeacherId(Classes classes) throws Exception {
        
        return this.classes.getAllClassesByTeacherId(classes);
    }
}
