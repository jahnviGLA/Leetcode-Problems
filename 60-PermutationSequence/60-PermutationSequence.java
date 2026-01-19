// Last updated: 1/19/2026, 1:17:00 PM
import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        StringBuilder result = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact[i - 1];
        }
        return result.toString();
    }
}
