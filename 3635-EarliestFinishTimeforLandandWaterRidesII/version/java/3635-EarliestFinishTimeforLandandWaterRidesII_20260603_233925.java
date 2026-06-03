// Last updated: 6/3/2026, 11:39:25 PM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3                                  int[] waterStartTime, int[] waterDuration) {
4        int ans = Integer.MAX_VALUE;
5        ans = Math.min(ans, solve(landStartTime, landDuration,
6                                  waterStartTime, waterDuration));
7        ans = Math.min(ans, solve(waterStartTime, waterDuration,
8                                  landStartTime, landDuration));
9        return ans;
10    }
11    private int solve(int[] firstStart, int[] firstDur,
12                      int[] secondStart, int[] secondDur) {
13        int MAX = 200005;
14        int INF = Integer.MAX_VALUE / 2;
15        int[] minDur = new int[MAX + 2];
16        int[] minEnd = new int[MAX + 3];
17        Arrays.fill(minDur, INF);
18        Arrays.fill(minEnd, INF);
19        for (int i = 0; i < secondStart.length; i++) {
20            int s = secondStart[i];
21            int d = secondDur[i];
22            minDur[s] = Math.min(minDur[s], d);
23            minEnd[s] = Math.min(minEnd[s], s + d);
24        }
25        for (int i = 1; i <= MAX; i++) {
26            minDur[i] = Math.min(minDur[i], minDur[i - 1]);
27        }
28        for (int i = MAX - 1; i >= 0; i--) {
29            minEnd[i] = Math.min(minEnd[i], minEnd[i + 1]);
30        }
31        int res = INF;
32        for (int i = 0; i < firstStart.length; i++) {
33            int finishFirst = firstStart[i] + firstDur[i];
34            res = Math.min(res, finishFirst + minDur[finishFirst]);
35            res = Math.min(res, minEnd[finishFirst + 1]);
36        }
37        return res;
38    }
39}