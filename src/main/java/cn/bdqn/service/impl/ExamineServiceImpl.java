package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.ExamineMapper;
import cn.bdqn.pojo.Examine;
import cn.bdqn.service.ExamineService;
@Service
public class ExamineServiceImpl implements ExamineService {

	@Autowired
	private ExamineMapper examieMapper;
	
	@Override
	public int addExamine(Examine examine) {
		return  examieMapper.addExamine(examine);
	}

	@Override
	public List<Examine> getExamineByBeginId(String beginId) {
		return examieMapper.getExamineByBeginId(beginId);
	}

	@Override
	public List<Examine> getExamineByExamine(String examineId) {
		return examieMapper.getExamineByExamine(examineId);
	}

	@Override
	public List<Examine> getExamineByExamine2(String examineId) {
		return examieMapper.getExamineByExamine2(examineId);
	}

	@Override
	public List<Examine> getExamineByCc(String ccId) {
		return examieMapper.getExamineByCc(ccId);
	}

	@Override
	public Examine getExamineById(Integer examinePk) {
		return examieMapper.getExamineById(examinePk);
	}

	@Override
	public int agree(Integer examinePk) {
		return examieMapper.agree(examinePk);
	}

	@Override
	public int refuse(Integer examinePk) {
		return examieMapper.refuse(examinePk);
	}

	
}
