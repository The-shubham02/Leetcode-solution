class solve{
    int fun(int  i , int j, String a , String b,int[][] dp) {
            if( i == a.length() || j ==b.length()){
                return 0;
            }
            if(dp[i][j] != -1) return dp[i][j];

            if(a.charAt(i) == b.charAt(j)) return dp[i][j]= 1+ fun(i+1,j+1,a,b,dp);

            else
            {
                return dp[i][j]=Math.max(fun(i+1,j,a,b,dp),fun(i,j+1,a,b,dp));}

        }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int[][]dp =new int[word1.length()+1][word2.length()+1];
        for(int i =0; i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }

        solve s = new solve();
        int lcs = s.fun(0,0,word1,word2,dp);
          
        return word1.length() + word2.length() - (2*lcs);
    }
}