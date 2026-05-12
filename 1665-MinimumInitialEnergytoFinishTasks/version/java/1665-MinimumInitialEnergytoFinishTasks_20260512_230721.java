// Last updated: 5/12/2026, 11:07:21 PM
1class Solution {
2
3    public int minimumEffort(int[][] tasks) {
4        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
5        int ans = 0;
6        int remain = 0;
7        for (int[] task : tasks) {
8            if (remain <= task[1]) {
9                ans += task[1] - remain;
10            }
11            remain = Math.max(task[1] - task[0], remain - task[0]);
12        }
13        return ans;
14    }
15}