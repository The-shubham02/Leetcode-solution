class Solution {

    int fun(int row, int col1, int col2, int[][] grid, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) {
            return -1000000;
        }

        if (row == m - 1) {

            if (col1 == col2) {
                return grid[row][col1];
            }

            return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int cherries;

        if (col1 == col2) {
            cherries = grid[row][col1];
        } else {
            cherries = grid[row][col1] + grid[row][col2];
        }

        int best = -1000000;

        for (int move1 = -1; move1 <= 1; move1++) {

            for (int move2 = -1; move2 <= 1; move2++) {

                int next = fun(
                    row + 1,
                    col1 + move1,
                    col2 + move2,
                    grid,
                    dp
                );

                best = Math.max(best, next);
            }
        }

        return dp[row][col1][col2] = cherries + best;
    }

    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fun(0, 0, n - 1, grid, dp);
    }
}