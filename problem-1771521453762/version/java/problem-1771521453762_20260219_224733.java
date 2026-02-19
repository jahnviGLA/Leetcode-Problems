// Last updated: 2/19/2026, 10:47:33 PM
1class Solution {
2    public int countBinarySubstrings(String s) {
3        int prevCount = 0;
4        int currCount = 1;
5        int result = 0;
6        for (int i = 1; i < s.length(); i++) {           
7            if (s.charAt(i) == s.charAt(i - 1)) {
8                currCount++;
9            } else {
10                result += Math.min(prevCount, currCount);
11                prevCount = currCount;
12                currCount = 1;
13            }
14        }
15        result += Math.min(prevCount, currCount);       
16        return result;
17    }
18}
19