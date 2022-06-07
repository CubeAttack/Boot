package boot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Countdown {

    public static void getTime(){

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(2022, 7, 16, 17, 1);

        Duration duration = Duration.between(start, end);
        Period period = Period.between(start.toLocalDate(), end.toLocalDate());

        String date = period.getYears() + "Y " + period.getMonths() + "M " + period.getDays() + "d " +
                duration.toHoursPart() + "h " + duration.toMinutesPart()+ "m " + duration.toSecondsPart() + "s ";

        System.out.println(format(date, duration));
    }

    private static String format(String format, Duration duration){
        if(duration.isZero() || duration.isNegative())return "Abgelaufen";
        while (format.startsWith(String.valueOf(0))){
            format = format.substring(3);
        }
        return format;
    }
}