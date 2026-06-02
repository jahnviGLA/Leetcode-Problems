// Last updated: 6/3/2026, 12:47:12 AM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3                                  int[] waterStartTime, int[] waterDuration) {       
4        int ans = Integer.MAX_VALUE;        
5        int n = landStartTime.length;
6        int m = waterStartTime.length;
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < m; j++) {
9                int landFinish = landStartTime[i] + landDuration[i];
10                int finishAfterWater = Math.max(landFinish, waterStartTime[j])
11                                       + waterDuration[j];
12                ans = Math.min(ans, finishAfterWater);
13                int waterFinish = waterStartTime[j] + waterDuration[j];
14                int finishAfterLand = Math.max(waterFinish, landStartTime[i])
15                                      + landDuration[i];
16                ans = Math.min(ans, finishAfterLand);
17            }
18        }
19        return ans;
20    }
21}