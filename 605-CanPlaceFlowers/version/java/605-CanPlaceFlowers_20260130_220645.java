// Last updated: 1/30/2026, 10:06:45 PM
1class Solution {
2    public boolean canPlaceFlowers(int[] flowerbed, int n) {
3        int m = flowerbed.length;
4        for (int i = 0; i < m && n > 0; i++) {
5            if (flowerbed[i] == 1) continue;
6            boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
7            boolean rightEmpty = (i == m - 1) || (flowerbed[i + 1] == 0);
8            if (leftEmpty && rightEmpty) {
9                flowerbed[i] = 1;
10                n--;
11            }
12        }
13        return n <= 0;
14    }
15}
16