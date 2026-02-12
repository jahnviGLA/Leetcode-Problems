// Last updated: 2/12/2026, 2:12:29 PM
1class Solution {
2    public boolean isPowerOfThree(int n) {
3        if (n<=0) return false;  
4        if (n==1) return true;   
5        if (n%3!=0) return false;
6        return isPowerOfThree(n/3);
7        
8    }
9}