// Last updated: 2/18/2026, 12:10:00 PM
1import java.util.*;
2class Solution {
3    public int minStickers(String[] stickers, String target) {
4        int n = stickers.length;
5        int[][] stickerCount = new int[n][26];
6        for (int i = 0; i < n; i++) {
7            for (char c : stickers[i].toCharArray()) {
8                stickerCount[i][c - 'a']++;
9            }
10        }
11        Map<String, Integer> memo = new HashMap<>();
12        memo.put("", 0);        
13        int ans = dfs(stickerCount, target, memo);
14        return ans == Integer.MAX_VALUE ? -1 : ans;
15    }    
16    private int dfs(int[][] stickerCount, String target, Map<String, Integer> memo) {
17        if (memo.containsKey(target)) {
18            return memo.get(target);
19        }
20        int[] targetCount = new int[26];
21        for (char c : target.toCharArray()) {
22            targetCount[c - 'a']++;
23        }        
24        int min = Integer.MAX_VALUE;        
25        for (int[] sticker : stickerCount) {
26            if (sticker[target.charAt(0) - 'a'] == 0) continue;
27            StringBuilder sb = new StringBuilder();
28            for (int i = 0; i < 26; i++) {
29                if (targetCount[i] > 0) {
30                    int remaining = targetCount[i] - sticker[i];
31                    for (int k = 0; k < Math.max(0, remaining); k++) {
32                        sb.append((char) ('a' + i));
33                    }
34                }
35            }            
36            String rest = sb.toString();
37            int result = dfs(stickerCount, rest, memo);            
38            if (result != Integer.MAX_VALUE) {
39                min = Math.min(min, 1 + result);
40            }
41        }
42        memo.put(target, min);
43        return min;
44    }
45}
46