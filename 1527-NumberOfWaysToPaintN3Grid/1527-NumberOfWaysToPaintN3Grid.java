// Last updated: 1/19/2026, 1:15:03 PM
class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long dpA = 6; 
        long dpB = 6; 
        for (int i = 2; i <= n; i++) {
            long newA = (2 * dpA + 2 * dpB) % MOD;
            long newB = (2 * dpA + 3 * dpB) % MOD;
            dpA = newA;
            dpB = newB;
        }
        return (int)((dpA + dpB) % MOD);
    }
}
