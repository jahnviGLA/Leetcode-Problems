// Last updated: 5/27/2026, 11:54:59 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int[] lastLower = new int[26];
4        int[] firstUpper = new int[26];
5        for (int i = 0; i < 26; i++) {
6            lastLower[i] = -1;
7            firstUpper[i] = Integer.MAX_VALUE;
8        }
9        for (int i = 0; i < word.length(); i++) {
10            char ch = word.charAt(i);
11            if (Character.isLowerCase(ch)) {
12                lastLower[ch - 'a'] = i;
13            } else {
14                firstUpper[ch - 'A'] =
15                    Math.min(firstUpper[ch - 'A'], i);
16            }
17        }
18        int count = 0;
19        for (int i = 0; i < 26; i++) {
20            if (lastLower[i] != -1 &&
21                firstUpper[i] != Integer.MAX_VALUE &&
22                lastLower[i] < firstUpper[i]) {
23
24                count++;
25            }
26        }
27        return count;
28    }
29}