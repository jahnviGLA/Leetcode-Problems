// Last updated: 6/30/2026, 1:12:21 PM
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        if (s.length()!=t.length()) return false;
4        int[] freq = new int[26];
5        for (char c:s.toCharArray()) {
6            freq[c-'a']++;
7        }
8        for (char c:t.toCharArray()) {
9            freq[c-'a']--;
10            if (freq[c-'a']<0) return false;
11        }
12        return true;
13    }
14}
15