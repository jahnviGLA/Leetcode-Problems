// Last updated: 3/16/2026, 10:05:25 AM
1import java.util.*;
2
3class Solution {
4    public List<String> summaryRanges(int[] nums) {
5
6        List<String> result = new ArrayList<>();
7
8        int i = 0;
9
10        while (i < nums.length) {
11
12            int start = nums[i];
13
14            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
15                i++;
16            }
17
18            int end = nums[i];
19
20            if (start == end) {
21                result.add(String.valueOf(start));
22            } else {
23                result.add(start + "->" + end);
24            }
25
26            i++;
27        }
28
29        return result;
30    }
31}