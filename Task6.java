package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public boolean isSubstring(String s, String t) {
        Pattern format = Pattern.compile(".*" + s + ".*");
        Matcher matcher = format.matcher(t);
        return matcher.find();
    }
}
