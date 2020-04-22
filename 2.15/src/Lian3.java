import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Lian3 {
    //练习3：用Calendar类来使用add方法，在原日期上增加年/月/日
    //set方法，直接设置年/月/日
    //提示:calendar.add(Calendar.MONTH, 1);下一个月;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        System.out.println("当前日期：\t" + format(c.getTime()));
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天:\t" +format(c.getTime()));
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("去年的今天:\t" +format(c.getTime()));
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天:\t" +format(c.getTime()));

    }
    private static String format(Date time) {
        return sdf.format(time);
    }
}
