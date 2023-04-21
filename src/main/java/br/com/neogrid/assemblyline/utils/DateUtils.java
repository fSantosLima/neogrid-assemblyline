package br.com.neogrid.assemblyline.utils;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class DateUtils {
    public static long getMinutesUntil(LocalTime localTime, LocalTime timeLimit) {
        long minutesUntil = localTime.until(timeLimit, ChronoUnit.MINUTES);
        if (minutesUntil < 0) {
            minutesUntil += 24 * 60;
        }
        return minutesUntil;
    }
}
