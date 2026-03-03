// Last updated: 3/3/2026, 10:31:05 PM
1class Solution {
2    public char findKthBit(int n, int k) {
3        if (n == 1) return '0';       
4        int mid = 1 << (n - 1);          
5        if (k == mid) {
6            return '1';
7        } 
8        else if (k < mid) {
9            return findKthBit(n - 1, k);
10        } 
11        else {
12            char bit = findKthBit(n - 1, (1 << n) - k);
13            return bit == '0' ? '1' : '0';
14        }
15    }
16}