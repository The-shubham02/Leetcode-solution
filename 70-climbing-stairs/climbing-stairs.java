class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        fun f = new fun();
        return f.solve(n, dp);
    }
}

class fun {
    public int solve(int n, int[] dp) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != -1) {
            return dp[n];
        }

        int one = solve(n - 1, dp);
        int two = solve(n - 2, dp);

        dp[n] = one + two;

        return dp[n];
    }
}