package edu.hw1;

public class Task4 {

    public String fixString(String s) {
        int n = s.length();
        String t = "";
        for (int i = 0; i < n; i = i + 2) {
            if (i <= n - 2) {
                t += s.charAt(i + 1);
                t += s.charAt(i);
            } else {
                t += s.charAt(i);
            }
        }
        return t;
    }
}
