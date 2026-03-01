// Last updated: 3/1/2026, 10:14:56 PM
1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;        
4        for (char c : n.toCharArray()) {
5            maxDigit = Math.max(maxDigit, c - '0');
6        }      
7        return maxDigit;
8    }
9}