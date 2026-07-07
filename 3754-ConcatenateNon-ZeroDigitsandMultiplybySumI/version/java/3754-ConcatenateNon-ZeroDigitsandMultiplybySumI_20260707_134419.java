// Last updated: 7/7/2026, 1:44:19 PM
1class Solution {
2    public long sumAndMultiply(int n) {
3        int temp=0;
4        int sum=0;
5
6        while (n>0) {
7            int r=n%10;
8            sum +=r;
9            if (r!=0) {
10                temp=temp*10+r;
11            }
12            n/=10;
13        }
14        long rev=0;
15        while (temp>0) {
16            int rm=temp%10;
17            rev=rev*10+rm;
18            temp/=10;
19        }
20
21        return rev*sum;
22    }
23}