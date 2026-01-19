// Last updated: 1/19/2026, 1:14:46 PM
import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Sort happiness in ascending order
        Arrays.sort(happiness);

        long sum = 0;
        int n = happiness.length;

        // Pick k children from the end (largest values)
        for (int i = 0; i < k; i++) {
            int current = happiness[n - 1 - i] - i;
            if (current > 0) {
                sum += current;
            }
        }

        return sum;
    }
}
