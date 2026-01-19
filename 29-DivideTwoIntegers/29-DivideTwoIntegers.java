// Last updated: 1/19/2026, 1:17:39 PM
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int count = 1;
            while (temp >= (Integer.MIN_VALUE >> 1) && dividend <= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }
            dividend -= temp;
            result += count;
        }
        return negative ? -result : result;
    }
}
