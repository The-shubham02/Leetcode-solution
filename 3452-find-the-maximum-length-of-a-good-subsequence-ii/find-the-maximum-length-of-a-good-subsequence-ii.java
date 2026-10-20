
import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer>[] dp = new HashMap[k + 1];

        for (int c = 0; c <= k; c++) {
            dp[c] = new HashMap<>();
        }

        int[] maxLen = new int[k + 1];

        for (int num : nums) {
            for (int c = k; c >= 0; c--) {
                int same = dp[c].getOrDefault(num, 0) + 1;
                int different = 1;

                if (c > 0) {
                    different = maxLen[c - 1] + 1;
                }

                int best = Math.max(same, different);

                dp[c].put(num, best);
                maxLen[c] = Math.max(maxLen[c], best);
            }
        }

        return maxLen[k];
    }
}
