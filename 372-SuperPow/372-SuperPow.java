// Last updated: 1/19/2026, 1:15:43 PM
class Solution {
    private static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;
        for (int digit : b) {
            result = pow(result, 10);
            result = (result * pow(a, digit)) % MOD;
        }
        return result;
    }
    private int pow(int x, int n) {
        int res = 1;
        x %= MOD;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}
