// Last updated: 1/19/2026, 1:17:11 PM
class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] chess = new char[n][n];

     
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }

        List<int[]> queens = new ArrayList<>();
        dfs(chess, 0, queens);
        return result;
    }

    public void dfs(char[][] chess, int r, List<int[]> queens) {
        if (r == chess.length) { 
            List<String> rows = new ArrayList<>();
            for (char[] row : chess) {
                rows.add(new String(row));
            }
            result.add(rows);
            return;
        }

        for (int c = 0; c < chess.length; c++) {
            if (isItPossible(r, c, queens)) {
                chess[r][c] = 'Q';
                queens.add(new int[]{r, c});
                dfs(chess, r + 1, queens);
                chess[r][c] = '.'; 
                queens.remove(queens.size() - 1);
            }
        }
    }

    public boolean isItPossible(int r, int c, List<int[]> queens) {
        for (int[] q : queens) {
            int qr = q[0], qc = q[1];
            if (qc == c || Math.abs(qr - r) == Math.abs(qc - c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> results = sol.solveNQueens(4);

        for (List<String> board : results) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
