// Last updated: 2/1/2026, 10:20:44 PM
1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow = nums[0];
4        int fast = nums[0];
5        do {
6            slow = nums[slow];
7            fast = nums[nums[fast]];
8        } while (slow != fast);
9        slow = nums[0];
10        while (slow != fast) {
11            slow = nums[slow];
12            fast = nums[fast];
13        }
14        return slow;
15    }
16}
17