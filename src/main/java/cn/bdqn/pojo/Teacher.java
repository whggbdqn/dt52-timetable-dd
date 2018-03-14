package cn.bdqn.pojo;

public class Teacher {
    private Integer teacherId;

    private String name;

    private String gender;

    private String scheduleName;

    private Integer dr;
//钉钉上用户的id
    private String emplId;
    
    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", name=" + name + ", gender=" + gender + ", scheduleName="
                + scheduleName + ", dr=" + dr + ", emplId=" + emplId + "]";
    }


    public String getEmplId() {
        return emplId;
    }

    
    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName == null ? null : scheduleName.trim();
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
}