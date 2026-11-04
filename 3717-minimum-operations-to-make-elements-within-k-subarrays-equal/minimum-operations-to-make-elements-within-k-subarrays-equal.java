
import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0;
        int rightSize = 0;

        long leftSum = 0;
        long rightSum = 0;

        void addToMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeFromMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void add(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                addToMap(left, val);
                leftSize++;
                leftSum += val;
            } else {
                addToMap(right, val);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        void remove(int val) {

            if (left.containsKey(val)) {
                removeFromMap(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                removeFromMap(right, val);
                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        void balance() {

            while (leftSize > rightSize + 1) {

                int val = left.lastKey();

                removeFromMap(left, val);
                leftSize--;
                leftSum -= val;

                addToMap(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {

                int val = right.firstKey();

                removeFromMap(right, val);
                rightSize--;
                rightSum -= val;

                addToMap(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {

            int median = left.lastKey();

            long costLeft =
                (long) median * leftSize - leftSum;

            long costRight =
                rightSum - (long) median * rightSize;

            return costLeft + costRight;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window

        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {

            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        // Step 2: Dynamic Programming

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Selecting zero windows costs zero
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int t = 0; t <= k; t++) {

            for (int i = 0; i < n; i++) {

                if (dp[t][i] == INF) {
                    continue;
                }

                // Choice 1: Skip current index

                dp[t][i + 1] = Math.min(
                    dp[t][i + 1],
                    dp[t][i]
                );

                // Choice 2: Select window of size x

                if (t < k && i + x <= n) {

                    dp[t + 1][i + x] = Math.min(
                        dp[t + 1][i + x],
                        dp[t][i] + cost[i]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
