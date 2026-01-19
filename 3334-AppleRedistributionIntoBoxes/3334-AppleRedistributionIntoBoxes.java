// Last updated: 1/19/2026, 1:14:42 PM
import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Sort capacities in ascending order
        Arrays.sort(capacity);

        int usedBoxes = 0;
        int currentCapacity = 0;

        // Pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            usedBoxes++;

            if (currentCapacity >= totalApples) {
                return usedBoxes;
            }
        }

        return usedBoxes; // guaranteed possible as per problem statement
    }
}
