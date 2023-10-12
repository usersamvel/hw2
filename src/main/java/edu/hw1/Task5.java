package edu.hw1;

public class Task5 {

    static final int DIGIT = 9;
    static final int BASE = 10;

    public int child(int m) {
        int n = m;
        int c = 0;
        int digits = 0;
        while (n > 0) {
            int a = n % BASE;
            n = n / BASE;
            int b = n % BASE;
            n = n / BASE;
            c = c + (a + b) * (int) Math.pow(BASE, digits);
            if (a + b >= BASE) {
                digits += 2;
            } else {
                digits += 1;
            }
        }
        return c;
    }

    public boolean isPalindrome(int n) {
        String s = Integer.toString(n);
        int l = s.length();
        for (int i = 0; i < l / 2 + 1; ++i) {
            if (s.charAt(i) != s.charAt(l - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeDescendant(int m) {
        int n = m;
        if (n < 0) {
            throw new IllegalArgumentException("negative number");
        }
        if (n < DIGIT) {
            return true;
        }
        while (n >= BASE) {
            if (isPalindrome(n)) {
                return true;
            }
            n = child(n);
        }
        return false;
    }
}
