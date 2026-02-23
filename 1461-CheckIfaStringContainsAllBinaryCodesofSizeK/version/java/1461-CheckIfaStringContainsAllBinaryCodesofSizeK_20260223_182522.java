// Last updated: 2/23/2026, 6:25:22 PM
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        int needed = 1 << k;   // 2^k
4        boolean[] seen = new boolean[needed];
5        int count = 0;        
6        int mask = 0;      
7        for (int i = 0; i < s.length(); i++) {
8            mask = ((mask << 1) & (needed - 1)) | (s.charAt(i) - '0');
9            if (i >= k - 1) {
10                if (!seen[mask]) {
11                    seen[mask] = true;
12                    count++;
13                    if (count == needed) return true;
14                }
15            }
16        }        
17        return false;
18    }
19}