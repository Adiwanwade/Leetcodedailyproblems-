import java.util.Arrays;

class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] dp = new int[rows][cols];
        
        
        for (int j = cols - 2; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
               
                if (i - 1 >= 0 && grid[i - 1][j + 1] > grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                }
                if (grid[i][j + 1] > grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                }
                if (i + 1 < rows && grid[i + 1][j + 1] > grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
            }
        }

        
        int maxMoves = 0;
        for (int i = 0; i < rows; i++) {
            maxMoves = Math.max(maxMoves, dp[i][0]);
        }
        
        return maxMoves;
    }
}
