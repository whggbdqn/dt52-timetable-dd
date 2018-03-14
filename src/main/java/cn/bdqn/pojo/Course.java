package cn.bdqn.pojo;

public class Course {
    private Integer coursePk;

    private String courseName;

    private String courseContent;

    private Integer dr;

    @Override
	public String toString() {
		return "Course [coursePk=" + coursePk + ", courseName=" + courseName
				+ ", courseContent=" + courseContent + ", dr=" + dr + "]";
	}

	public Integer getCoursePk() {
        return coursePk;
    }

    public void setCoursePk(Integer coursePk) {
        this.coursePk = coursePk;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent == null ? null : courseContent.trim();
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
}