class Solve {

    int fun(int i, int end, int[] nums, int[] dp) {

        if (i > end)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int pick = nums[i] + fun(i + 2, end, nums, dp);
        int notPick = fun(i + 1, end, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        Solve s = new Solve();

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int ans1 = s.fun(0, n - 2, nums, dp1);
        int ans2 = s.fun(1, n - 1, nums, dp2);

        return Math.max(ans1, ans2);
    }
}