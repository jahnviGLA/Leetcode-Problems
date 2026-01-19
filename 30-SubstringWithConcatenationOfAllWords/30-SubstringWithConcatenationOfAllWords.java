// Last updated: 1/19/2026, 1:17:37 PM
import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;
        int wordLen = words[0].length();
        int k = words.length;
        int totalLen = wordLen * k;
        if (s.length() < totalLen) return result;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == k) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
