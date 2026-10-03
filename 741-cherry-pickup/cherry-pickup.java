class Solution {

    int fun(int r1, int c1, int r2, int[][] grid, int[][][] dp) {

        int n = grid.length;

        int c2 = r1 + c1 - r2;

        // Out of bounds
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) {
            return -1000000;
        }

        // Blocked cell
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1000000;
        }

        // Destination
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // Already calculated
        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        // Take cherries
        int cherries;

        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        // 4 choices
        int downDown = fun(r1 + 1, c1, r2 + 1, grid, dp);

        int downRight = fun(r1 + 1, c1, r2, grid, dp);

        int rightDown = fun(r1, c1 + 1, r2 + 1, grid, dp);

        int rightRight = fun(r1, c1 + 1, r2, grid, dp);

        int best = Math.max(
                        Math.max(downDown, downRight),
                        Math.max(rightDown, rightRight)
                    );

        return dp[r1][c1][r2] = cherries + best;
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;

        int[][][] dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        int ans = fun(0, 0, 0, grid, dp);

        return Math.max(0, ans);
    }
}