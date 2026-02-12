// Last updated: 2/12/2026, 2:19:20 PM
1class Solution {
2    public boolean isPowerOfFour(int n) {
3        if(n<=0) return false;
4        if(n==1) return true;
5        if(n%4!=0) return false;
6        return isPowerOfFour(n/4);
7    }
8}