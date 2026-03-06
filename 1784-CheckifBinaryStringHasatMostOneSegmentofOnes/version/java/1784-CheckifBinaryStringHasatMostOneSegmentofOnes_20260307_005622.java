// Last updated: 3/7/2026, 12:56:22 AM
1class Solution {
2    public boolean checkOnesSegment(String s) {
3        boolean zeroFound = false;
4
5        for (int i = 0; i < s.length(); i++) {
6            if (s.charAt(i) == '0') {
7                zeroFound = true;
8            } 
9            else if (zeroFound) {
10                return false;
11            }
12        }
13
14        return true;
15    }
16}