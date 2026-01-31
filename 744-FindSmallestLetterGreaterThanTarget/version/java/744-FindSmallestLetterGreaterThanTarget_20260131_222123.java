// Last updated: 1/31/2026, 10:21:23 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0, right = letters.length - 1;
4        while (left <= right) {
5            int mid = left + (right - left) / 2;
6            if (letters[mid] <= target) {
7                left = mid + 1;
8            } else {
9                right = mid - 1;
10            }
11        }
12        return left < letters.length ? letters[left] : letters[0];
13    }
14}
15