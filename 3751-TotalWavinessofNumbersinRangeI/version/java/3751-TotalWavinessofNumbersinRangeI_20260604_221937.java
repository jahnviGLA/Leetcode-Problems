// Last updated: 6/4/2026, 10:19:37 PM
1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        int ans = 0;
4        for (int num = num1; num <= num2; num++) {
5            ans += getWaviness(num);
6        }
7        return ans;
8    }
9    private int getWaviness(int num) {
10        String s = Integer.toString(num);
11        if (s.length() < 3) {
12            return 0;
13        }
14        int count = 0;
15        for (int i = 1; i < s.length() - 1; i++) {
16            int prev = s.charAt(i - 1) - '0';
17            int curr = s.charAt(i) - '0';
18            int next = s.charAt(i + 1) - '0';
19            if (curr > prev && curr > next) {
20                count++;
21            } 
22            else if (curr < prev && curr < next) {
23                count++;
24            }
25        }
26        return count;
27    }
28}