// Last updated: 2/9/2026, 11:25:36 PM
1class Solution {
2    public int expressiveWords(String s, String[] words) {
3        int count = 0;
4        for (String word : words) {
5            if (isStretchy(s, word)) {
6                count++;
7            }
8        }
9        return count;
10    }
11    private boolean isStretchy(String s, String word) {
12        int i = 0, j = 0;
13        while (i < s.length() && j < word.length()) {
14            if (s.charAt(i) != word.charAt(j)) return false;
15            char c = s.charAt(i);
16            int lenS = 0, lenW = 0;
17            while (i < s.length() && s.charAt(i) == c) {
18                i++;
19                lenS++;
20            }
21            while (j < word.length() && word.charAt(j) == c) {
22                j++;
23                lenW++;
24            }
25            if (lenS < lenW) return false;
26            if (lenS > lenW && lenS < 3) return false;
27        }
28        return i == s.length() && j == word.length();
29    }
30}
31