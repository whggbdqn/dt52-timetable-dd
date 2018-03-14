package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.TeacherMapper;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper mapper;
/**
 * 根据teacher中的emplid或name获取teacher
 */
    @Override
    public Teacher getTeacher(Teacher teacher) throws Exception {
        
        Teacher teacher2 = new Teacher();
        teacher2.setEmplId(teacher.getEmplId());

//        根据emplid查询teacher
        Teacher getTeacher = mapper.getTeacher(teacher2);
        
//        如果第一次登陆则根据emlid查询不到teacher，则根据name查询teacher，并将emlid存入数据库
        if (getTeacher == null) {
//            先将emplid置为null，因sql语句中需满足emlid、name都成立，如不置空则查询不到数据

            teacher2.setEmplId(null);
            teacher2.setName(teacher.getName());

//            根据name查询teacher并将emlid存入数据库
            getTeacher = mapper.getTeacher(teacher2);
            
            if (getTeacher != null) {
                getTeacher.setEmplId(teacher.getEmplId());
                mapper.updateEmplId(getTeacher);
            }
        }
        
        return getTeacher;
    }

/**
 * 在第一次登陆时将钉钉emplid存入数据库
 */
    @Override
    public int updateEmplId(Teacher teacher) throws Exception {
        
        return mapper.updateEmplId(teacher);
        
    }

@Override
public List<Teacher> getAllTeacher() {
	return mapper.getAllTeacher();
}

}
