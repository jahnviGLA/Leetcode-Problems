// Last updated: 5/7/2026, 11:32:51 PM
1class Solution {
2
3    record Item(int value, int index) {}
4
5    public int[] maxValue(int[] nums) {
6        int n = nums.length;
7        int[] ans = new int[n];
8        Item[] prevMax = new Item[n];
9
10        Item prev = new Item(Integer.MIN_VALUE, -1);
11        for (int i = 0; i < n; i++) {
12            if (nums[i] > prev.value()) {
13                prev = new Item(nums[i], i);
14            }
15            prevMax[i] = prev;
16        }
17
18        process(n - 1, Integer.MAX_VALUE, 0, prevMax, ans, nums);
19        return ans;
20    }
21
22    private void process(
23        int r,
24        int rightMin,
25        int rightMax,
26        Item[] prevMax,
27        int[] ans,
28        int[] nums
29    ) {
30        int pMax = prevMax[r].value();
31        int pivotIndex = prevMax[r].index();
32
33        int currMax = pMax <= rightMin ? pMax : rightMax;
34
35        int nextRightMin = Math.min(pMax, rightMin);
36        for (int i = pivotIndex; i <= r; i++) {
37            ans[i] = currMax;
38            nextRightMin = Math.min(nextRightMin, nums[i]);
39        }
40
41        if (pivotIndex == 0) {
42            return;
43        }
44
45        process(pivotIndex - 1, nextRightMin, currMax, prevMax, ans, nums);
46    }
47}