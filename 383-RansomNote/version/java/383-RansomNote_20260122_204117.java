// Last updated: 1/22/2026, 8:41:17 PM
1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        int[] freq = new int[26];
4        for (char c : magazine.toCharArray()) {
5            freq[c - 'a']++;
6        }
7        for (char c : ransomNote.toCharArray()) {
8            if (freq[c - 'a'] == 0) {
9                return false;
10            }
11            freq[c - 'a']--;
12        }
13        return true;
14    }
15}
16