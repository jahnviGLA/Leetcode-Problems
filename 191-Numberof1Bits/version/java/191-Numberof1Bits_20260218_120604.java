// Last updated: 2/18/2026, 12:06:04 PM
1class Solution {
2    public int hammingWeight(int n) {
3        int count = 0;       
4        while (n != 0) {
5            n = n & (n - 1);  
6            count++;
7        }   
8        return count;
9    }
10}
11