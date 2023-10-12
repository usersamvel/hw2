package edu.hw1;

public class Task7 {
    public String conv(int m) {
        int n = m;
        String s = "";
        while (n > 0) {
            s = (n % 2) + s;
            n = n / 2;
        }
        return s;
    }

    public int rotateLeft(int n, int shift) {
        String s = conv(n);
        int l = s.length();
        int sh = shift % l;
        String t = "";
        for (int i = 0; i < sh; ++i) {
            t = t + s.charAt(i);
        }
        String r = "";
        for (int i = sh; i < l; ++i) {
            r = r + s.charAt(i);
        }
        s = r + t;
        int ans = 0;
        for (int i = l - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                ans += (int) Math.pow(2, l - 1 - i);
            }
        }
        return ans;
    }

    public int rotateRight(int n, int shift) {
        String s = conv(n);
        int l = s.length();
        int sh = shift % l;
        String t = "";
        for (int i = l - 1; i >= l - sh; --i) {
            t = s.charAt(i) + t;
        }
        String r = "";
        for (int i = l - sh; i >= 0; --i) {
            r = s.charAt(i) + r;
        }
        s = t + r;
        int ans = 0;
        for (int i = l - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                ans += (int) Math.pow(2, l - 1 - i);
            }
        }
        return ans;
    }
}
