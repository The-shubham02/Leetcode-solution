class Solution {
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, s1, s2);
    }

    public int fun(int i, int j, String s1, String s2) {

        if (i == s1.length()) {
            int sum = 0;

            while (j < s2.length()) {
                sum += s2.charAt(j);
                j++;
            }

            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;

            while (i < s1.length()) {
                sum += s1.charAt(i);
                i++;
            }

            return sum;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = fun(i + 1, j + 1, s1, s2);
        }

        int deleteS1 = s1.charAt(i) + fun(i + 1, j, s1, s2);

        int deleteS2 = s2.charAt(j) + fun(i, j + 1, s1, s2);

        return dp[i][j] = Math.min(deleteS1, deleteS2);
    }
}