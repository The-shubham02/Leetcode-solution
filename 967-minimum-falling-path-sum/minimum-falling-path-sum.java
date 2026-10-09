
class solve {
    int fun(int[][] matrix, int i, int j, int[][] dp) {
        int n = matrix.length;

        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        if (i == n - 1) return matrix[i][j];

        if (dp[i][j] != -101) {
            return dp[i][j];
        }

        int c1 = fun(matrix, i + 1, j, dp);
        int c2 = fun(matrix, i + 1, j - 1, dp);
        int c3 = fun(matrix, i + 1, j + 1, dp);

        int ans = Math.min(c1, Math.min(c2, c3));

        return dp[i][j] = matrix[i][j] + ans;
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-101 );
        }

        solve s = new solve();

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, s.fun(matrix, 0, j, dp));
        }

        return ans;
    }
}
