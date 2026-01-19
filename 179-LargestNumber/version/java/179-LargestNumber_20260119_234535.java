// Last updated: 1/19/2026, 11:45:35 PM
1import java.util.*;
2class Solution {
3    public String largestNumber(int[] nums) {
4        String[] arr = new String[nums.length];
5        for (int i = 0; i < nums.length; i++) {
6            arr[i] = String.valueOf(nums[i]);
7        }
8        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
9        if (arr[0].equals("0")) {
10            return "0";
11        }
12        StringBuilder sb = new StringBuilder();
13        for (String s : arr) {
14            sb.append(s);
15        }
16        return sb.toString();
17    }
18}
19