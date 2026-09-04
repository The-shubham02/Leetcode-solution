
class Solution {
  
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        solve s = new solve();
        int ans = s.fun(0,amount,coins ,dp);
     return ans;
     }
     }
     
     
     
 class solve{
        int fun(int index, int amount, int[] coins, int[][] dp){

if(amount == 0)
    return 1;
    if( amount <0 || index == coins.length){
         return 0;}
        if(dp[index][amount] != -1) return dp[index][amount];

    int c1 = fun(index, amount - coins[index], coins, dp);
    int c2 = fun(index+1 , amount, coins, dp);
    
    return dp[index][amount] = c1 + c2;
}
    }

   