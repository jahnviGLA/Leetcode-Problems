// Last updated: 1/20/2026, 10:50:02 PM
1import java.util.*;
2class Solution {
3    public boolean wordPattern(String pattern, String s) {
4        String[] words = s.split(" ");
5        if (pattern.length() != words.length) {
6            return false;
7        }
8        Map<Character, String> charToWord = new HashMap<>();
9        Map<String, Character> wordToChar = new HashMap<>();
10        for (int i = 0; i < pattern.length(); i++) {
11            char ch = pattern.charAt(i);
12            String word = words[i];
13            if (charToWord.containsKey(ch)) {
14                if (!charToWord.get(ch).equals(word)) {
15                    return false;
16                }
17            } else {
18                if (wordToChar.containsKey(word)) {
19                    return false;
20                }
21                charToWord.put(ch, word);
22                wordToChar.put(word, ch);
23            }
24        }
25        return true;
26    }
27}
28