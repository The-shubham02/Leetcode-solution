class Solution {

    Set<String> ans = new HashSet<>();
    String s;
    int n;

    public List<String> removeInvalidParentheses(String s) {

        this.s = s;
        this.n = s.length();

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } 
            else if (c == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(0, left, right, 0, 0, "");

        return new ArrayList<>(ans);
    }

    void dfs(int i, int left, int right,
             int lcnt, int rcnt, String curr) {

        if (i == n) {

            if (left == 0 && right == 0) {
                ans.add(curr);
            }

            return;
        }

        if (lcnt < rcnt) {
            return;
        }

        char c = s.charAt(i);

        // Remove current character
        if (c == '(' && left > 0) {
            dfs(i + 1, left - 1, right,
                lcnt, rcnt, curr);
        }

        if (c == ')' && right > 0) {
            dfs(i + 1, left, right - 1,
                lcnt, rcnt, curr);
        }

        // Keep current character
        if (c == '(') {

            dfs(i + 1, left, right,
                lcnt + 1, rcnt, curr + c);

        } else if (c == ')') {

            dfs(i + 1, left, right,
                lcnt, rcnt + 1, curr + c);

        } else {

            dfs(i + 1, left, right,
                lcnt, rcnt, curr + c);
        }
    }
}