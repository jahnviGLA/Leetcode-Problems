// Last updated: 2/2/2026, 10:14:31 PM
1import java.util.*;
2class Solution {
3    public List<String> findRepeatedDnaSequences(String s) {
4        Set<String> seen = new HashSet<>();
5        Set<String> repeated = new HashSet<>();
6        for (int i = 0; i + 10 <= s.length(); i++) {
7            String sub = s.substring(i, i + 10);
8            if (!seen.add(sub)) {
9                repeated.add(sub);
10            }
11        }
12        return new ArrayList<>(repeated);
13    }
14}
15