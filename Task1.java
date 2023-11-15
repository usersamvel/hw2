package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    final static int END_FIRST_DATE = 17;
    final static int START_SECOND_DATE = 20;
    final static int END_SECOND_DATE = 37;
    final static int MILLISECONDS_IN_MINUTE = 60000;
    final static int MINUTES_IN_HOUR = 60;

    public String averageTime(String[] list) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        int n = list.length;
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            try {
                Date start = sdf.parse(list[i].substring(0, END_FIRST_DATE));
                Date end = sdf.parse(list[i].substring(START_SECOND_DATE, END_SECOND_DATE));
                sum += ((end.getTime() - start.getTime()) / MILLISECONDS_IN_MINUTE);
            } catch (ParseException e) {
                throw new ParseException("error", -1);
            }
        }
        sum = sum / n;
        long hours = sum / MINUTES_IN_HOUR;
        long mins = sum % MINUTES_IN_HOUR;
        return String.format("%dч %dм", hours, mins);
    }
}
