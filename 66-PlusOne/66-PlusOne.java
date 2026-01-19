// Last updated: 1/19/2026, 1:16:53 PM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // carry
        }

        // All digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
