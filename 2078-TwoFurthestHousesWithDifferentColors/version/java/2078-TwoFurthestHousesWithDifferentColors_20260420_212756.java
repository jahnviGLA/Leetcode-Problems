// Last updated: 4/20/2026, 9:27:56 PM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length;
4        int left = 0;
5        int right = n - 1;
6        while (colors[right] == colors[0]) {
7            right--;
8        }
9        int maxDist1 = right; 
10        while (colors[left] == colors[n - 1]) {
11            left++;
12        }
13        int maxDist2 = (n - 1) - left;
14        return Math.max(maxDist1, maxDist2);
15    }
16}