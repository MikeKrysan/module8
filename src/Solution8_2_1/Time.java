package Solution8_2_1;
/*
Измените в классе Time код так, чтобы на экран вывелось:

Thu Jan 01 00:00:01 UTC 1970


 */
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
    int millis = 1001;  //// любое число от 1000 до 1999 ()
    public void getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        System.out.println(calendar.getTime());

    }
}
