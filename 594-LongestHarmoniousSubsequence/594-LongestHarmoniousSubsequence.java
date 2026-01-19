// Last updated: 1/19/2026, 1:15:33 PM
import java.util.HashMap;
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                maxLen = Math.max(
                    maxLen,
                    freq.get(key) + freq.get(key + 1)
                );
            }
        }
        return maxLen;
    }
}
