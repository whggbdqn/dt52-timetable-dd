package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Examine;

public interface ExamineService {

	int addExamine(Examine examine);//添加审批记录
	
	List<Examine> getExamineByBeginId(String beginId);//根据抄送人查看审批信息
	
	List<Examine> getExamineByExamine(String exmineId);//根据审批人查看待我审批的:0
	
	List<Examine> getExamineByExamine2(String exmineId);//根据审批人查看我已审批的:1
	
	List<Examine> getExamineByCc(String ccId);//根据抄送人查看抄送我的

	Examine getExamineById(Integer examinePk);//根据审批表主键获取审批信息

	int agree(Integer examinePk);//修改为审批通过状态

	int refuse(Integer examinePk);//修改状态为拒绝
	
}
