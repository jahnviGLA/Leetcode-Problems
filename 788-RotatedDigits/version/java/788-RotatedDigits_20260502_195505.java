// Last updated: 5/2/2026, 7:55:05 PM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4        for (int i = 1; i <= n; i++) {
5            if (isGood(i)) count++;
6        }
7        return count;
8    }   
9    private boolean isGood(int x) {
10        boolean different = false;
11        int temp = x;
12        while (temp > 0) {
13            int d = temp % 10;
14            if (d == 3 || d == 4 || d == 7) return false;
15            if (d == 2 || d == 5 || d == 6 || d == 9) different = true;
16            temp /= 10;
17        }
18        return different;
19    }
20}