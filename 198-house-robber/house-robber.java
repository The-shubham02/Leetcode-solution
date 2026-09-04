
class solve{
    int fun(int i, int[] nums , int[] dp){
        int n = nums.length;
        if (i>=n) 
        return 0;
        if(dp[i] != -1){
            return dp[i];
        }
            int c1 = nums[i]+ fun(i+2 , nums ,dp);
            int c2 = fun(i+1, nums,dp);
            return dp[i] = Math.max(c1,c2);
  }

}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+2];
    Arrays.fill(dp , -1);
       solve s = new solve();
       int answer = s.fun(0,nums, dp);
        return answer;
    }
}