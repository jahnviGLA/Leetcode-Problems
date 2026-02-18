// Last updated: 2/18/2026, 12:13:32 PM
1class Solution {
2    public int computeArea(int ax1, int ay1, int ax2, int ay2,
3                           int bx1, int by1, int bx2, int by2) {
4        int area1 = (ax2 - ax1) * (ay2 - ay1);
5        int area2 = (bx2 - bx1) * (by2 - by1);
6        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
7        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
8        int overlapArea = 0;
9        if (overlapWidth > 0 && overlapHeight > 0) {
10          overlapArea = overlapWidth * overlapHeight;
11        }        
12        return area1 + area2 - overlapArea;
13    }
14}
15