// Last updated: 7/7/2026, 1:47:44 PM
1class Solution {
2    public long sumAndMultiply(int n) {
3        int temp=0;
4        int sum=0;
5        while (n>0) {
6            int r=n%10;
7            sum +=r;
8            if (r!=0) {
9                temp=temp*10+r;
10            }
11            n/=10;
12        }
13        long rev=0;
14        while (temp>0) {
15            int rm=temp%10;
16            rev=rev*10+rm;
17            temp/=10;
18        }
19        return rev*sum;
20    }
21}