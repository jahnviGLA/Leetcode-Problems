// Last updated: 6/23/2026, 1:38:34 PM
1class Solution {
2  public int maxArea(int[] height) {
3    int ans=0;
4    int l=0;
5    int r=height.length-1;
6    while(l<r){
7      final int minHeight=Math.min(height[l],height[r]);
8      ans=Math.max(ans,minHeight*(r-l));
9      if(height[l]<height[r])
10        ++l;
11      else
12        --r;
13    }
14    return ans;
15  }
16}