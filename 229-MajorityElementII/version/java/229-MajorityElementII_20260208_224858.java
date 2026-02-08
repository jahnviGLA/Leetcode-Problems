// Last updated: 2/8/2026, 10:48:58 PM
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int candidate1 = 0, candidate2 = 0;
4        int count1 = 0, count2 = 0;
5        for (int num : nums) {
6            if (num == candidate1) {
7                count1++;
8            } else if (num == candidate2) {
9                count2++;
10            } else if (count1 == 0) {
11                candidate1 = num;
12                count1 = 1;
13            } else if (count2 == 0) {
14                candidate2 = num;
15                count2 = 1;
16            } else {
17                count1--;
18                count2--;
19            }
20        }
21        count1 = 0;
22        count2 = 0;
23        for (int num : nums) {
24            if (num == candidate1) count1++;
25            else if (num == candidate2) count2++;
26        }
27        List<Integer> result = new ArrayList<>();
28        int n = nums.length;
29        if (count1 > n / 3) result.add(candidate1);
30        if (count2 > n / 3) result.add(candidate2);
31        return result;
32    }
33}
34