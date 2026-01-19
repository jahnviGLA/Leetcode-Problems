// Last updated: 1/19/2026, 1:17:29 PM
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }
    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) return false;
            if (board[i][col] == ch) return false;
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }
}
