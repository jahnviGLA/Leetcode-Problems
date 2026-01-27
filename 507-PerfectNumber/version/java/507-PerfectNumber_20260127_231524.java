// Last updated: 1/27/2026, 11:15:24 PM
1class Solution {
2    public boolean checkPerfectNumber(int num) {
3        if (num <= 1) return false;
4        int sum = 1; 
5        for (int i = 2; i * i <= num; i++) {
6            if (num % i == 0) {
7                sum += i;
8                if (i != num / i) {
9                    sum += num / i;
10                }
11            }
12        }
13        return sum == num;
14    }
15}
16