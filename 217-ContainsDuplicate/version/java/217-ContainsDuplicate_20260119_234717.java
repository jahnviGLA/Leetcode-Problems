// Last updated: 1/19/2026, 11:47:17 PM
1import java.util.*;
2class Solution {
3    public boolean containsDuplicate(int[] nums) {
4        Set<Integer> set = new HashSet<>();
5        for (int num : nums) {
6            if (!set.add(num)) {
7                return true; 
8            }
9        }
10        return false;
11    }
12}
13