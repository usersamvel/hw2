package edu.hw1;

public class Task1 {

    static final int SEC_IN_MIN = 60;

    public int minutesToSeconds(String s) {
        String[] part = s.split(":");
        if (Integer.parseInt(part[1]) >= SEC_IN_MIN) {
            return -1;
        } else {
            return SEC_IN_MIN * Integer.parseInt(part[0]) + Integer.parseInt(part[1]);
        }
    }
}
