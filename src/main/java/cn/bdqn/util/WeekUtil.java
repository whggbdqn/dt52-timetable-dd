package cn.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
 * @ClassName WeekUtil
 * @Description 日期转换工具类
 * @author yw
 * @Date 2018年2月3日 下午10:01:21
 * @version 1.0.0
 */
public class WeekUtil {
//    禁止实例化
    private WeekUtil() {
    }

    private static  SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar cal=new GregorianCalendar();
    /**
     * 
     * @Description (获取当前周的周一是多少号)
     * @return
     */
    public static String  getMonday() {
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        
//        设置星期一为一星期的第一天
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek());
        
        Date first=cal.getTime();
        String format = formater.format(first);
 
        return format;
        
    }
    /**
     * 
     * @Description (获取当前周的周日是多少号)
     * @return
     */
    public static String  getSunday() {
        
      cal.setFirstDayOfWeek(Calendar.MONDAY);
//      获取这个星期的最后一天
      cal.setTime(new Date());
      cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
      Date last=cal.getTime();
      
      String format = formater.format(last);
      return format;
    }
    
    /**
     * 
     * @Description (根据日期获取周中天)
     * @param date
     * @return
     */
    public static int getWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
