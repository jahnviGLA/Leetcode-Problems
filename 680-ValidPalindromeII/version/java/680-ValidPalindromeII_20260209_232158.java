// Last updated: 2/9/2026, 11:21:58 PM
1class Solution {
2    public boolean validPalindrome(String s) {
3        int left = 0, right = s.length() - 1;
4        while (left < right) {
5            if (s.charAt(left) == s.charAt(right)) {
6                left++;
7                right--;
8            } else {
9                return isPalindrome(s, left + 1, right) ||
10                       isPalindrome(s, left, right - 1);
11            }
12        }
13        return true;
14    }
15    private boolean isPalindrome(String s, int left, int right) {
16        while (left < right) {
17            if (s.charAt(left) != s.charAt(right)) return false;
18            left++;
19            right--;
20        }
21        return true;
22    }
23}
24