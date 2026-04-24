// Last updated: 4/24/2026, 10:13:45 PM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int l = 0, r = 0, u = 0;
4        for(char ch : moves.toCharArray()){
5            if(ch == 'L') l++;
6            else if(ch == 'R') r++;
7            else u++; // '_'
8        }
9        return Math.abs(r - l) + u;
10    }
11}