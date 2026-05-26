// Last updated: 5/26/2026, 11:59:42 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int count = 0;
4        for(char ch = 'a'; ch <= 'z'; ch++) {
5            if(word.contains(String.valueOf(ch)) &&
6               word.contains(String.valueOf(Character.toUpperCase(ch)))) {
7                count++;
8            }
9        }
10        return count;
11    }
12}