package edu.hw1;

import java.util.Arrays;

public class Task6 {

    static final int BASE = 10;
    static final int MAX = 9999;
    static final int MIN = 1000;
    static final int MAG_NUM = 6174;
    static final int DIG_NUM = 3;

    public int countK(int m) {
        int n = m;
        if (n > MAX || n <= MIN) {
            return -1;
        }
        int count = 0;
        while (n != MAG_NUM) {
            int a = n % BASE;
            n = n / BASE;
            int b = n % BASE;
            n = n / BASE;
            int c = n % BASE;
            n = n / BASE;
            int d = n % BASE;
            int[] digits = {a, b, c, d};
            Arrays.sort(digits);
            if (digits[0] == digits[DIG_NUM]) {
                return -1;
            }
            n = digits[DIG_NUM] * BASE * BASE * BASE + digits[2] * BASE * BASE + digits[1] * BASE + digits[0]
                - (digits[0] * BASE * BASE * BASE + digits[1] * BASE * BASE + digits[2] * BASE + digits[DIG_NUM]);
            ++count;
        }
        return count;
    }
}
