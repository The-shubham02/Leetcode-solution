class Solution {
    int[] dp;
    int[] sum;

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        sum = new int[max + 1];

        for (int x : nums) {
            sum[x] += x;
        }

        dp = new int[max + 2];
        Arrays.fill(dp, -1);

        return fun(0, max);
    }

    int fun(int i, int max) {

        if (i > max) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Take
        int take = sum[i] + fun(i + 2, max);

        // Not Take
        int notTake = fun(i + 1, max);

        return dp[i] = Math.max(take, notTake);
    }
}