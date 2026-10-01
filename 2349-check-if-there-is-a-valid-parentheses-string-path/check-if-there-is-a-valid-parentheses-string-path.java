import java.util.*;

class solve {

    boolean fun(int i, int j, int a, int b, char[][] grid, int[][][] dp) {

        if (i >= grid.length || j >= grid[0].length)
            return false;

        if (grid[i][j] == '(')
            a++;
        else
            b++;

        if (b > a)
            return false;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return a == b;

        int balance = a - b;

        if (dp[i][j][balance] != -1)
            return dp[i][j][balance] == 1;

        boolean ans = fun(i + 1, j, a, b, grid, dp)
                   || fun(i, j + 1, a, b, grid, dp);

        dp[i][j][balance] = ans ? 1 : 0;

        return ans;
    }
}

class Solution {

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        int[][][] dp = new int[m][n][m + n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        solve s = new solve();

        return s.fun(0, 0, 0, 0, grid, dp);
    }
}