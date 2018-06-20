package date;


import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTranslate {
    // 获取年月日时分秒
    public void getDateByCalendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
    }

    // 获取年月日时分秒 java8
    public void getDateByLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }

    public void getLastDay() {
        Calendar time = Calendar.getInstance();
        int day = time.getActualMaximum(Calendar.DAY_OF_WEEK);
        System.out.println(day);
    }
}
