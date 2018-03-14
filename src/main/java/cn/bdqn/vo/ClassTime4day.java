package cn.bdqn.vo;

import java.util.Arrays;
import java.util.Date;


/**
 * 
 * @ClassName ClassTime4day
 * @Description 一天的班次信息
 * @author yw
 * @Date 2018年2月3日 下午9:08:45
 * @version 1.0.0
 */
public class ClassTime4day {
    
/**
 * 班次日期
 */
    private Date curDate;
    /**
     * 班次数组（上午，下午，晚上）
     */
    private ClassTime[] classTime = new ClassTime[3];
    
    
    @Override
    public String toString() {
        return "ClassTime4day [curDate=" + curDate + ", classTime=" + Arrays.toString(classTime) + "]";
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public ClassTime[] getClassTime() {
        return classTime;
    }

    
    public void setClassTime(ClassTime[] classTime) {
        this.classTime = classTime;
    }

    public void setClassTime(int index,ClassTime classTime) {
        this.classTime[index] = classTime;
    }
}
