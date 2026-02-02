// Last updated: 2/2/2026, 10:17:07 PM
1import java.util.*;
2class Solution {
3    public boolean isIsomorphic(String s, String t) {
4        if (s.length() != t.length()) return false;
5        Map<Character, Character> mapST = new HashMap<>();
6        Map<Character, Character> mapTS = new HashMap<>();
7        for (int i = 0; i < s.length(); i++) {
8            char c1 = s.charAt(i);
9            char c2 = t.charAt(i);
10            if (mapST.containsKey(c1)) {
11                if (mapST.get(c1) != c2) return false;
12            } else {
13                mapST.put(c1, c2);
14            }
15            if (mapTS.containsKey(c2)) {
16                if (mapTS.get(c2) != c1) return false;
17            } else {
18                mapTS.put(c2, c1);
19            }
20        }
21        return true;
22    }
23}
24