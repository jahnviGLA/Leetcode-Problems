// Last updated: 1/19/2026, 1:17:12 PM
class Solution {
    public double myPow(double x, int n) {
        long power = n;   
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        double result = 1.0;
        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }
            x *= x;
            power >>= 1;
        }
        return result;
    }
}
