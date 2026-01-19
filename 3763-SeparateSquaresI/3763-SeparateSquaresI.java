// Last updated: 1/19/2026, 1:14:45 PM
class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE, high = 0;
        for (int[] sq : squares) {
            int y = sq[1], l = sq[2];
            totalArea += (double) l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }
        double target = totalArea / 2.0;
        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;
            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double overlap = Math.max(0, Math.min(mid - y, l));
                areaBelow += overlap * l;
            }
            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
