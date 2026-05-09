// Last updated: 5/9/2026, 10:10:32 PM
1import java.util.*;
2class Solution {
3    public int[][] rotateGrid(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        int layers = Math.min(m, n) / 2;
7        for (int layer = 0; layer < layers; layer++) {
8            List<Integer> elements = new ArrayList<>();
9            int top = layer;
10            int left = layer;
11            int bottom = m - layer - 1;
12            int right = n - layer - 1;
13            for (int j = left; j <= right; j++) {
14                elements.add(grid[top][j]);
15            }
16            for (int i = top + 1; i <= bottom - 1; i++) {
17                elements.add(grid[i][right]);
18            }
19            for (int j = right; j >= left; j--) {
20                elements.add(grid[bottom][j]);
21            }
22            for (int i = bottom - 1; i >= top + 1; i--) {
23                elements.add(grid[i][left]);
24            }
25            int size = elements.size();
26            int rotate = k % size;
27            List<Integer> rotated = new ArrayList<>();
28            for (int i = 0; i < size; i++) {
29                rotated.add(elements.get((i + rotate) % size));
30            }
31            int idx = 0;
32            for (int j = left; j <= right; j++) {
33                grid[top][j] = rotated.get(idx++);
34            }
35            for (int i = top + 1; i <= bottom - 1; i++) {
36                grid[i][right] = rotated.get(idx++);
37            }
38            for (int j = right; j >= left; j--) {
39                grid[bottom][j] = rotated.get(idx++);
40            }
41            for (int i = bottom - 1; i >= top + 1; i--) {
42                grid[i][left] = rotated.get(idx++);
43            }
44        }
45        return grid;
46    }
47}