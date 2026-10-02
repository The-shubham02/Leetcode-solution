class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun(0, 0, n, "", ans);
        return ans;
    }

    void fun(int open, int close, int n, String s, List<String> ans) {

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            fun(open + 1, close, n, s + "(", ans);
        }

        if (close < open) {
            fun(open, close + 1, n, s + ")", ans);
        }
    }
}