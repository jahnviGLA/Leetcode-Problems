// Last updated: 1/19/2026, 1:14:56 PM
import java.util.*;
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = true; // water
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int j = 0; j < col; j++) {
            if (!grid[0][j]) {
                q.offer(new int[]{0, j});
                visited[0][j] = true;
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == row - 1) return true;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    !grid[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
