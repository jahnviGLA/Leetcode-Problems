// Last updated: 5/21/2026, 11:49:59 PM
1class Solution {
2    public int longestCommonPrefix(int[] arr1, int[] arr2) {
3        HashSet<String> set = new HashSet<>();
4        for (int num : arr1) {
5            String s = String.valueOf(num);            
6            for (int i = 1; i <= s.length(); i++) {
7                set.add(s.substring(0, i));
8            }
9        }        
10        int ans = 0;
11        for (int num : arr2) {
12            String s = String.valueOf(num);           
13            for (int i = 1; i <= s.length(); i++) {
14                String prefix = s.substring(0, i);                
15                if (set.contains(prefix)) {
16                    ans = Math.max(ans, i);
17                }
18            }
19        }        
20        return ans;
21    }
22}