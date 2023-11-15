package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task2 {
    static final String FORMAT = "yyyy-MM-dd";
    static final int SEC_IN_MIN = 60;
    static final int MIN_IN_HOUR = 60;
    static final int HOUR_IN_DAY = 24;
    static final int FRIDAY = 5;
    static final int DAY = 13;

    public ArrayList<String> friday13(int year) throws ParseException {
        ArrayList<String> answer = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        Date start = sdf.parse(String.format("%d-01-01", year));
        Date end = sdf.parse(String.format("%d-12-31", year));
        for (Date date = start; date.before(end);
             date = Date.from(date.toInstant().plusSeconds(SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY))) {
            if (date.getDay() == FRIDAY && date.getDate() == DAY) {
                answer.add(sdf.format(date));
            }
        }
        return answer;
    }

    public Date nextFriday13(String day) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        Date start = sdf.parse(day);
        for (Date date = start; ;
             date = Date.from(date.toInstant().plusSeconds(SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY))) {
            if (date.getDay() == FRIDAY && date.getDate() == DAY) {
                return date;
            }
        }
    }
}
