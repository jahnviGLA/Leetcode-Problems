// Last updated: 2/11/2026, 9:59:51 PM
1import java.util.*;
2class Solution {
3    public boolean wordBreak(String s, List<String> wordDict) {
4        Set<String> set = new HashSet<>(wordDict);
5        int n = s.length();
6        boolean[] dp = new boolean[n + 1];
7        dp[0] = true; 
8        for (int i = 1; i <= n; i++) {
9            for (int j = 0; j < i; j++) {
10                if (dp[j] && set.contains(s.substring(j, i))) {
11                    dp[i] = true;
12                    break;
13                }
14            }
15        }
16        return dp[n];
17    }
18}
19