package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    static final int FOUR = 4;
    static final int FIVE = 5;
    static final int SIX = 6;
    static final int SEVEN = 7;
    static final int EIGHT = 8;
    static final int NINE = 9;
    static final int THREE = 3;

    public Optional<LocalDate> parseDate(String string) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Pattern format1 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher1 = format1.matcher(string);
        Pattern format2 = Pattern.compile("\\d{4}-\\d{2}-\\d{1}");
        Matcher matcher2 = format2.matcher(string);
        Pattern format3 = Pattern.compile("\\d{1}/\\d{1}/\\d{4}");
        Matcher matcher3 = format3.matcher(string);
        Pattern format4 = Pattern.compile("\\d{1}/\\d{1}/\\d{2}");
        Matcher matcher4 = format4.matcher(string);
        Pattern format5 = Pattern.compile("\\d+ day ago");
        Matcher matcher5 = format5.matcher(string);
        Pattern format6 = Pattern.compile("\\d+ days ago");
        Matcher matcher6 = format6.matcher(string);
        LocalDate date = LocalDate.now();
        Optional<LocalDate> ans;
        if (string.equals("tomorrow")) {
            ans = Optional.of(date.plusDays(1));
        } else if (string.equals("today")) {
            ans = Optional.of(date);
        } else if (string.equals("yesterday")) {
            ans = Optional.of(date.plusDays(-1));
        } else if (matcher1.find()) {
            ans = Optional.of(LocalDate.parse(string, dtf));
        } else if (matcher2.find()) {
            String year = string.substring(0, FOUR);
            String month = string.substring(FIVE, SEVEN);
            String day = string.substring(EIGHT, NINE);
            String answer = year + "-" + month + "-" + "0" + day;
            ans = Optional.of(LocalDate.parse(answer, dtf));
        } else if (matcher3.find()) {
            String day = string.substring(0, 1);
            String month = string.substring(2, THREE);
            String year = string.substring(FOUR, EIGHT);
            String answer = year + "-" + "0" + month + "-" + "0" + day;
            ans = Optional.of(LocalDate.parse(answer, dtf));
        } else if (matcher4.find()) {
            String day = string.substring(0, 1);
            String month = string.substring(2, THREE);
            String year = string.substring(FOUR, SIX);
            String answer = "19" + year + "-" + "0" + month + "-" + "0" + day;
            ans = Optional.of(LocalDate.parse(answer, dtf));
        } else if (matcher5.find()) {
            ans = Optional.of(date.plusDays(-1));
        } else if (matcher6.find()) {
            int len = string.length();
            int number = Integer.parseInt(string.substring(0, len - NINE));
            ans = Optional.of(date.plusDays(-number));
        } else {
            ans = Optional.empty();
        }
        return ans;
    }
}
