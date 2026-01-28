// Last updated: 1/28/2026, 10:53:46 PM
1class Solution {
2    public int thirdMax(int[] nums) {
3        Long first = null, second = null, third = null;
4        for (int num : nums) {
5            long val = num;
6            if ((first != null && val == first) ||
7                (second != null && val == second) ||
8                (third != null && val == third)) {
9                continue;
10            }
11            if (first == null || val > first) {
12                third = second;
13                second = first;
14                first = val;
15            } 
16            else if (second == null || val > second) {
17                third = second;
18                second = val;
19            } 
20            else if (third == null || val > third) {
21                third = val;
22            }
23        }
24        return (third == null) ? first.intValue() : third.intValue();
25    }
26}
27