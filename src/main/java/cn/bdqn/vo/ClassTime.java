package cn.bdqn.vo;

import java.util.Date;

import cn.bdqn.enums.Period;
import cn.bdqn.pojo.Teacher;

/**
 * 
 * @ClassName ClassTime
 * @Description 一个班次信息
 * @author yw
 * @Date 2018年2月3日 下午4:28:43
 * @version 1.0.0
 */
public class ClassTime {
	/**
	 * 日期
	 */
	private Date schDate; 
	
	/**
	 * 教师
	 */
	private String teacherName;
	
	/**
	 * 课表主键
	 */
    private Integer schedulePk;
    /**
     * 教室
     */
    private String roomName;
    /**
     * 班级
     */
    private String className;
    /**
     * 时间段
     */
    private Period peroid;
    /**
     * 课时信息
     */
    private String  courseContent;
    
    
    public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Date getSchDate() {
		return schDate;
	}


	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}


	public Integer getSchedulePk() {
        return schedulePk;
    }

    
    public void setSchedulePk(Integer schedulePk) {
        this.schedulePk = schedulePk;
    }

    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public Period getPeroid() {
        return peroid;
    }
    
    public void setPeroid(Period peroid) {
        this.peroid = peroid;
    }


    
    public String getCourseContent() {
        return courseContent;
    }


    
    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }


    @Override
    public String toString() {
        return "ClassTime [schDate=" + schDate + ", teacherName=" + teacherName + ", schedulePk=" + schedulePk
                + ", roomName=" + roomName + ", className=" + className + ", peroid=" + peroid + ", courseContent="
                + courseContent + "]";
    }
    
}
