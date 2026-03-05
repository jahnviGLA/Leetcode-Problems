// Last updated: 3/5/2026, 6:36:20 PM
1class Solution {
2    public int minOperations(String s) {
3        int count1 = 0; 
4        int count2 = 0;        
5        for(int i = 0; i < s.length(); i++){
6            char c = s.charAt(i);
7            char expected1 = (i % 2 == 0) ? '0' : '1';
8            char expected2 = (i % 2 == 0) ? '1' : '0';           
9            if(c != expected1) count1++;
10            if(c != expected2) count2++;
11        }        
12        return Math.min(count1, count2);
13    }
14}