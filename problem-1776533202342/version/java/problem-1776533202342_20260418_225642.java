// Last updated: 4/18/2026, 10:56:42 PM
1class Solution {
2    public int mirrorDistance(int n) {
3        int rev=0, temp=n;
4        while(n>0){
5            int r=n%10;
6            rev=(rev*10)+r;
7            n=n/10;
8        }
9        int dist= Math.abs(rev-temp);
10        return dist;
11    }
12}