// Last updated: 5/19/2026, 10:14:49 PM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int i = 0, j = 0;
4        while (i < nums1.length && j < nums2.length) {
5            if (nums1[i] == nums2[j]) {
6                return nums1[i];
7            }
8            if (nums1[i] < nums2[j]) {
9                i++;
10            } else {
11                j++;
12            }
13        }
14        return -1;
15    }
16}