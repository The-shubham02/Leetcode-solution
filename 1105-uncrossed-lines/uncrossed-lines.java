class solve{
 int fun(int i, int j, int[] nums3, int[] nums4, int[][] dp){
    if(i>=nums3.length || j>= nums4.length)
    return 0;
    if(dp[i][j]!= -1) return dp[i][j];
    if(nums3[i] == nums4[j]) return dp[i][j]=1 + fun(i+1, j+1, nums3,nums4,dp);
    int c1 = fun(i+1, j , nums3, nums4,dp);
    int c2  = fun(i, j+1, nums3,nums4,dp);
    return dp[i][j] = Math.max(c1,c2);

 }   }
    class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i<nums1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        solve y = new solve();
        return y.fun(0,0,nums1,nums2, dp);
    }
}