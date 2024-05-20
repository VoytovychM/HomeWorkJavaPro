package homework20240513;

import java.time.Instant;
import java.time.Month;
import java.util.*;

//Составить список времен начала всех занятий по Java за июнь, если предположить,
// что они будут проходить каждый понедельник/среду c 9:30 CET.
public class Schedule {
    public static void main(String[] args) {
        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("Germany"));
        List<Instant> dates = new ArrayList<>();

        calendar.set(2024, Calendar.JUNE, 30, 9, 30);
        Instant nm = calendar.toInstant();

        calendar.set(2024, Calendar.JUNE, 1, 9, 30);


        while (calendar.toInstant().isBefore(nm)) {
            calendar.add(Calendar.DAY_OF_MONTH,1);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                dates.add(calendar.toInstant());
            }

        }


        dates.forEach(System.out::println);
    }
}
