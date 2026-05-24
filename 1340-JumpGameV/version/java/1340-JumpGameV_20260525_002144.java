// Last updated: 5/25/2026, 12:21:44 AM
1class Solution {
2    int[] dp;
3    public int maxJumps(int[] arr, int d) {
4        int n = arr.length;
5        dp = new int[n];
6        int ans = 1;
7        for(int i = 0; i < n; i++){
8            ans = Math.max(ans, dfs(arr, d, i));
9        }
10        return ans;
11    }
12    private int dfs(int[] arr, int d, int i){
13        if(dp[i] != 0){
14            return dp[i];
15        }
16        int max = 1;
17        for(int x = 1; x <= d && i + x < arr.length; x++){
18            if(arr[i + x] >= arr[i]){
19                break;
20            }
21            max = Math.max(max,
22                    1 + dfs(arr, d, i + x));
23        }
24        for(int x = 1; x <= d && i - x >= 0; x++){
25            if(arr[i - x] >= arr[i]){
26                break;
27            }
28            max = Math.max(max,
29                    1 + dfs(arr, d, i - x));
30        }
31        dp[i] = max;
32        return max;
33    }
34}