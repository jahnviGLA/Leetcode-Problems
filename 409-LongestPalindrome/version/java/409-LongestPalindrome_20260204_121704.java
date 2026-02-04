// Last updated: 2/4/2026, 12:17:04 PM
1class Solution {
2    public int longestPalindrome(String s) {
3        int[] freq = new int[128]; 
4        for (char c : s.toCharArray()) {
5            freq[c]++;
6        }
7        int length = 0;
8        boolean hasOdd = false;
9        for (int count : freq) {
10            length += (count / 2) * 2;
11            if (count % 2 == 1) {
12                hasOdd = true;
13            }
14        }
15        if (hasOdd) length++;
16        return length;
17    }
18}
19