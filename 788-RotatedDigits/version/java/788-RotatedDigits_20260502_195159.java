// Last updated: 5/2/2026, 7:51:59 PM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4        for (int i = 1; i <= n; i++) {
5            if (isGood(i)) count++;
6        }
7        return count;
8    }
9    
10    private boolean isGood(int x) {
11        boolean different = false;
12        int temp = x;
13        while (temp > 0) {
14            int d = temp % 10;
15            if (d == 3 || d == 4 || d == 7) return false;
16            if (d == 2 || d == 5 || d == 6 || d == 9) different = true;
17            temp /= 10;
18        }
19        return different;
20    }
21}