class Solution {

    int solve(int start, int end, int[] nums) {

        int[] dp = new int[end + 3];

        for (int i = end; i >= start; i--) {
            int pick = nums[i] + dp[i + 2];
            int notPick = dp[i + 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[start];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(
                solve(0, n - 2, nums),
                solve(1, n - 1, nums)
        );
    }
}