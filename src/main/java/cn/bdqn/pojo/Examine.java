package cn.bdqn.pojo;

import java.util.Date;

public class Examine {
    private Integer examinePk;
    
    private String beginTeacherId;
    
    private Teacher beginTeacher;

    private Integer examineTeacherId;
    
    private Teacher examineTeacher;
    
    private Integer ccTeacherId;
    
    private Teacher ccTeacher;

    private Integer schedulePk;
   
    private Date schDate;

    private String schTime;

    private Integer classesId;

    private Classes className;
    
    private Integer roomId;
    
    private Room roomName;

    private Integer teacherId;

    private Teacher teacherName;
    
    private Integer courseId;
    
    private Course courseName;
    
    private String cause;
    
    private Integer pass;

    
    
    
    
    public Teacher getBeginTeacher() {
		return beginTeacher;
	}

	public void setBeginTeacher(Teacher beginTeacher) {
		this.beginTeacher = beginTeacher;
	}

	public Teacher getExamineTeacher() {
		return examineTeacher;
	}

	public void setExamineTeacher(Teacher examineTeacher) {
		this.examineTeacher = examineTeacher;
	}

	public Teacher getCcTeacher() {
		return ccTeacher;
	}

	public void setCcTeacher(Teacher ccTeacher) {
		this.ccTeacher = ccTeacher;
	}

	public Classes getClassName() {
		return className;
	}

	public void setClassName(Classes className) {
		this.className = className;
	}

	public Room getRoomName() {
		return roomName;
	}

	public void setRoomName(Room roomName) {
		this.roomName = roomName;
	}

	public Teacher getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(Teacher teacherName) {
		this.teacherName = teacherName;
	}

	public Course getCourseName() {
		return courseName;
	}

	public void setCourseName(Course courseName) {
		this.courseName = courseName;
	}

	public Integer getExaminePk() {
        return examinePk;
    }

    public void setExaminePk(Integer examinePk) {
        this.examinePk = examinePk;
    }
    
    public String getBeginTeacherId() {
		return beginTeacherId;
	}

	public void setBeginTeacherId(String beginTeacherId) {
		this.beginTeacherId = beginTeacherId;
	}

	public Integer getExamineTeacherId() {
        return examineTeacherId;
    }

    public void setExamineTeacherId(Integer examineTeacherId) {
        this.examineTeacherId = examineTeacherId;
    }

    public Integer getCcTeacherId() {
		return ccTeacherId;
	}

	public void setCcTeacherId(Integer ccTeacherId) {
		this.ccTeacherId = ccTeacherId;
	}

	public Integer getSchedulePk() {
        return schedulePk;
    }

    public void setSchedulePk(Integer schedulePk) {
        this.schedulePk = schedulePk;
    }

    public Date getSchDate() {
        return schDate;
    }

    public void setSchDate(Date schDate) {
        this.schDate = schDate;
    }

    public String getSchTime() {
        return schTime;
    }

    public void setSchTime(String schTime) {
        this.schTime = schTime == null ? null : schTime.trim();
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Examine [examinePk=" + examinePk + ", beginTeacherId="
				+ beginTeacherId + ", beginTeacher=" + beginTeacher
				+ ", examineTeacherId=" + examineTeacherId
				+ ", examineTeacher=" + examineTeacher + ", ccTeacherId="
				+ ccTeacherId + ", ccTeacher=" + ccTeacher + ", schedulePk="
				+ schedulePk + ", schDate=" + schDate + ", schTime=" + schTime
				+ ", classesId=" + classesId + ", className=" + className
				+ ", roomId=" + roomId + ", roomName=" + roomName
				+ ", teacherId=" + teacherId + ", teacherName=" + teacherName
				+ ", courseId=" + courseId + ", courseName=" + courseName
				+ ", cause=" + cause + ", pass=" + pass + "]";
	}

	
	
	
    
    
}