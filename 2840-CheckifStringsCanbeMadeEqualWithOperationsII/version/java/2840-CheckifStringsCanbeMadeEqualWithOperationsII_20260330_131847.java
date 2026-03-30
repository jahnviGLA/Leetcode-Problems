// Last updated: 3/30/2026, 1:18:47 PM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] even1 = new int[26];
4        int[] odd1 = new int[26];
5        int[] even2 = new int[26];
6        int[] odd2 = new int[26];
7
8        for (int i = 0; i < s1.length(); i++) {
9            if (i % 2 == 0) {
10                even1[s1.charAt(i) - 'a']++;
11                even2[s2.charAt(i) - 'a']++;
12            } else {
13                odd1[s1.charAt(i) - 'a']++;
14                odd2[s2.charAt(i) - 'a']++;
15            }
16        }
17
18        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
19    }
20}