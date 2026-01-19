// Last updated: 1/19/2026, 1:15:01 PM
import java.util.*;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int result = 0;
        int left = 0;              // Bob’s side (smallest)
        int right = n - 1;         // Alice’s side (largest)
        
        while (left < right) {
            // Alice takes the largest
            right--; 
            // You take the next largest
            result += piles[right];
            right--;
            // Bob takes the smallest
            left++;
        }
        
        return result;
    }
}
