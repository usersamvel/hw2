package edu.hw1;

public class Task2 {

    static final int DIGIT = 9;
    static final int BASE = 10;

    public int countDigits(int n) {

        int m = n;
        int digits = 1;
        while (m > DIGIT) {
            m = m / BASE;
            ++digits;
        }
        return digits;
    }
}
