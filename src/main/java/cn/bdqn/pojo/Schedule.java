package cn.bdqn.pojo;

import java.util.Date;
/**
 * 
 * @ClassName Schedule
 * @Description 一天的一个时间段（上午，下午，晚上），哪个教室班次信息
 * @author yw
 * @Date 2018年2月3日 下午9:53:53
 * @version 1.0.0
 */
public class Schedule {
    
    private Integer schedulePk;
/**
 * 班次日期
 */
    private Date schDate;
/**
 * 上午，下午，晚上
 */
    private String schTime;

    private Integer classesId;

    private Integer roomId;

    private Integer teacherId;
/**
 * 课时
 */
    private Integer courseId;

    private String week;

    private Integer dr;
    
    /**
     * 星期一
     */
    private String firstDay;
    /**
     * 星期日
     */
    private String endDay;
    
    /**
     * 班级信息
     */
    private Classes classes;
    
/**
 * 教室信息
 */
    private Room room;
    
    /**
     * 教师信息
     */
    private Teacher teacher;
    /**
     * 课时信息
     */
    private Course course;
    
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
        this.schTime = schTime;
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
    
    public String getWeek() {
        return week;
    }
    
    public void setWeek(String week) {
        this.week = week;
    }
    
    public Integer getDr() {
        return dr;
    }
    
    public void setDr(Integer dr) {
        this.dr = dr;
    }
    
    public String getFirstDay() {
        return firstDay;
    }
    
    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }
    
    public String getEndDay() {
        return endDay;
    }
    
    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
    
    public Classes getClasses() {
        return classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Schedule [schedulePk=" + schedulePk + ", schDate=" + schDate + ", schTime=" + schTime + ", classesId="
                + classesId + ", roomId=" + roomId + ", teacherId=" + teacherId + ", courseId=" + courseId + ", week="
                + week + ", dr=" + dr + ", firstDay=" + firstDay + ", endDay=" + endDay + ", classes=" + classes
                + ", room=" + room + ", teacher=" + teacher + ", course=" + course + "]";
    }

}