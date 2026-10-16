
class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;
    private long[] squareSum;
    private long[] lazy;
    private int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastSeen = new int[100001];

        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastSeen[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            lastSeen[nums[i]] = i;

            ans = (ans + squareSum[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end,
                        int left, int right) {
        if (start > right || end < left) {
            return;
        }

        if (start >= left && end <= right) {
            apply(node, start, end);
            return;
        }

        pushDown(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int start, int end) {
        long len = end - start + 1;

        squareSum[node] =
            (squareSum[node] + 2L * sum[node] + len) % MOD;

        sum[node] = (sum[node] + len) % MOD;

        lazy[node] = (lazy[node] + 1) % MOD;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        applyLazy(node * 2, start, mid, lazy[node]);
        applyLazy(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    private void applyLazy(int node, int start, int end, long val) {
        long len = end - start + 1;

        squareSum[node] = (
            squareSum[node]
            + 2L * val * sum[node]
            + val * val % MOD * len
        ) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }
}
