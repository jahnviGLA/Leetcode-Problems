// Last updated: 3/3/2026, 10:36:29 PM
1import java.util.*;
2class Solution {
3    public int[] findRightInterval(int[][] intervals) {
4        int n = intervals.length;
5        int[][] starts = new int[n][2];
6        for (int i = 0; i < n; i++) {
7            starts[i][0] = intervals[i][0];
8            starts[i][1] = i;
9        }
10        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));      
11        int[] result = new int[n];
12        for (int i = 0; i < n; i++) {
13            int target = intervals[i][1];            
14            int left = 0, right = n - 1;
15            int index = -1;            
16            while (left <= right) {
17                int mid = left + (right - left) / 2;                
18                if (starts[mid][0] >= target) {
19                    index = starts[mid][1];
20                    right = mid - 1; 
21                } else {
22                    left = mid + 1;
23                }
24            }           
25            result[i] = index;
26        }       
27        return result;
28    }
29}