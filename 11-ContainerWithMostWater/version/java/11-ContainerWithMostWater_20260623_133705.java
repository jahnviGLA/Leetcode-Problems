// Last updated: 6/23/2026, 1:37:05 PM
1class Solution {
2  public int maxArea(int[] height) {
3    int ans = 0;
4    int l = 0;
5    int r = height.length - 1;
6
7    while (l < r) {
8      final int minHeight = Math.min(height[l], height[r]);
9      ans = Math.max(ans, minHeight * (r - l));
10      if (height[l] < height[r])
11        ++l;
12      else
13        --r;
14    }
15
16    return ans;
17  }
18}