package edu.hw1;

import java.util.Arrays;

public class Task3 {
    public boolean isNestable(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return false;
        }
        return (Arrays.stream(a).max().getAsInt() < Arrays.stream(b).max().getAsInt()
            && Arrays.stream(a).min().getAsInt() > Arrays.stream(b).min().getAsInt());
    }
}
