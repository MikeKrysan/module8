package Solution8_2_2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
    String date = "";
    public void getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        date = dateFormat.format(calendar.getTime());
        System.out.println(date);
    }
}
