package cn.bdqn.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;

import cn.bdqn.converter.Schedule2ClassTime;
import cn.bdqn.enums.Period;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Course;
import cn.bdqn.pojo.Examine;
import cn.bdqn.pojo.Room;
import cn.bdqn.pojo.Schedule;
import cn.bdqn.pojo.Teacher;
import cn.bdqn.service.ClassesService;
import cn.bdqn.service.CourseService;
import cn.bdqn.service.ExamineService;
import cn.bdqn.service.RoomService;
import cn.bdqn.service.ScheduleService;
import cn.bdqn.service.TeacherService;
import cn.bdqn.vo.ClassTime;

@Controller
public class ChangeClassController {

	@Autowired
    private ClassesService services;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ExamineService examineService;
	
	
	@RequestMapping("/getOneScheduleById")
	public String getOneScheduleById(Integer schedulePK,String emplId,Model model) throws Exception{
		//System.err.println("==================="+emplId);
		Schedule schedule = new Schedule();
		schedule.setSchedulePk(schedulePK);
		Schedule scheduleBySchedulePk = scheduleService.getScheduleBySchedulePk(schedule);
		//System.err.println("+++++++++++++++++++++++++=================>>>>>>>>>>>"+scheduleBySchedulePk);

		Schedule2ClassTime s2ct = new Schedule2ClassTime();
		ClassTime classTime = s2ct.convert(scheduleBySchedulePk);
		//System.err.println("+++++++++++++++++++++++++=================>>>>>>>>>>>"+classTime);
		model.addAttribute("emplId", emplId);
		if(Period.AM.equals(classTime.getPeroid())){
			model.addAttribute("am","selected" );
		};
		if(Period.PM.equals(classTime.getPeroid())){
			model.addAttribute("pm","selected" );
		};
		if(Period.EM.equals(classTime.getPeroid())){
			model.addAttribute("em","selected" );
		};
		model.addAttribute("classtime",classTime );
		return "changeclass";
	}
	
	//获取所有的班级
	@RequestMapping("/getAllClasses")
	@ResponseBody
	public List<Classes> getAllClasses(){
		List<Classes> allClasses = services.getAllClasses();
		return allClasses;
	}
	
	//获取所有的教室
	@RequestMapping("/getAllRoom")
	@ResponseBody
	public List<Room> getAllRoom(){
		List<Room> allRoom = roomService.getAllRoom();
		return allRoom;
	}
	
	//获取所有的课程
	@RequestMapping("/getAllCourse")
	@ResponseBody
	public List<Course> getAllCourse(){
		List<Course> allCourse = courseService.getAllCourse();
		return allCourse;
	}
	

	//获取所有的教师信息
	@RequestMapping("/getAllTeacher")
	@ResponseBody
	public List<Teacher> getAllTeacher(){
		List<Teacher> allTeacher = teacherService.getAllTeacher();
		return allTeacher;
	}
	//提交审批信息
	@RequestMapping("/examine")
	@ResponseBody
	public int examine(Examine examine){
//		System.err.println("+=++++++++++++"+examine);
		return examineService.addExamine(examine);
	}
	
	//根据发起人查看审批信息
	@RequestMapping("/getExamineByBeginId")
	@ResponseBody
	public List<Examine> getExamineByBeginId(String beginId){
				List<Examine> examineByBeginId = examineService.getExamineByBeginId(beginId);
				return examineByBeginId;
	}
	
	//根据审批人查看待审批的审批信息
	@RequestMapping("/getExamineByExamine")
	@ResponseBody
	public List<Examine> getExamineByExamine(String examineId){
		 List<Examine> examineByExamine = examineService.getExamineByExamine(examineId);
		 return examineByExamine;
	}
	
	//根据审批人查看我已的审批信息
	@RequestMapping("/getExamineByExamine2")
	@ResponseBody
	public List<Examine> getExamineByExamine2(String examineId){
		System.err.println("===========================++++++++++++++++++++++++++++++<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+examineId);
		List<Examine> examineByExamine2 = examineService.getExamineByExamine2(examineId);
		for (Examine examine : examineByExamine2) {
			System.err.println("???????????????????????"+examine);
		}
		return examineByExamine2;
	}
	
	//根据审批人查看我已的审批信息
	@RequestMapping("/getExamineByCc")
	@ResponseBody     
	public List<Examine> getExamineByCc(String emplId){
		 List<Examine> examineByCc = examineService.getExamineByCc(emplId);
		
		 return examineByCc;
	}
	
	//同意审批
	@RequestMapping("/agree")
	public String agree(Integer examinePk){
		Examine examine = examineService.getExamineById(examinePk);
		Integer schedulePk = examine.getSchedulePk();
		Date schDate = examine.getSchDate();
		
		String schTime = examine.getSchTime();
		Integer classesId = examine.getClassesId();
		Integer roomId = examine.getRoomId();
		Integer teacherId = examine.getTeacherId();
		Integer courseId = examine.getCourseId();
		
		Schedule schedule = new Schedule();
		
		schedule.setSchedulePk(schedulePk);
		schedule.setSchDate(schDate);
		schedule.setSchTime(schTime);
		schedule.setClassesId(classesId);
		schedule.setRoomId(roomId);
		schedule.setTeacherId(teacherId);
		schedule.setCourseId(courseId);
		
		int num =  scheduleService.updateSchedule(schedule);
		int num2 = examineService.agree(examinePk);
		
		if(num==1&&num2==1){
			
			return "redirect:/approvalmanager.jsp";
		}
		
		return "index";
		
	}
	
	//拒绝审批
	@RequestMapping("/refuse")
	public String refuse(Integer examinePk){
		int num = examineService.refuse(examinePk);
		if(num==1){
			return "approvalmanager";
		}
		return "";
	}
}
