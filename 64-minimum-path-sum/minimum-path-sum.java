class solve{
    int fun(int[][] grid, int i, int j,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
             if(i>=m  || j>=n) return Integer.MAX_VALUE; 
            if(i==m-1 && j == n-1) return grid[i][j];
           
           
    if (dp[i][j] != -1) {
            return dp[i][j];
        }
            int c1 =  fun(grid,i,j+1,dp);
            int c2 =  fun(grid,i+1,j,dp);
         int ans = Math.min(c1,c2);
         return dp[i][j] = grid[i][j] +  ans;

    }
}
class Solution {
    public int minPathSum(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        solve s = new solve();
        return s.fun(grid,0,0,dp);
    }
}