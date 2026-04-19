// Last updated: 4/19/2026, 10:41:54 PM
1import java.util.*;
2class Solution {
3    public int maxDistance(int[] nums1, int[] nums2) {
4        int i = 0, j = 0;
5        int maxDist = 0;
6        while (i < nums1.length && j < nums2.length) {
7            if (nums1[i] <= nums2[j]) {
8                maxDist = Math.max(maxDist, j - i);
9                j++; 
10            } else {
11                i++;  
12            }
13        }
14        return maxDist;
15    }
16}