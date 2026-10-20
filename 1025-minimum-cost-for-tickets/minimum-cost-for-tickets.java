
import java.util.Arrays;

class Solution {
    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);

        return solve(0, days, costs);
    }

    private int solve(int i, int[] days, int[] costs) {
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int j = i;
        while (j < days.length && days[j] < days[i] + 1) {
            j++;
        }
        int oneDay = costs[0] + solve(j, days, costs);

        j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int sevenDay = costs[1] + solve(j, days, costs);

        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int thirtyDay = costs[2] + solve(j, days, costs);

        dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));

        return dp[i];
    }
}
