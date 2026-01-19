// Last updated: 1/19/2026, 1:15:19 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1; // try slower
            } else {
                left = mid + 1;  // too slow, need faster
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; // use long to prevent overflow
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p / k)
        }
        return hours <= h;
    }
}
