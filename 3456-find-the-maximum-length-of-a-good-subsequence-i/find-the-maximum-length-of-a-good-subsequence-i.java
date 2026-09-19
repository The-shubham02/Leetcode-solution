class Solution {
    int dp[][][];
    public int maximumLength(int[] nums, int k) {
        dp = new int[nums.length][nums.length + 1][k + 1];
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<=nums.length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
    return fun(0,-1,nums,k);
    }


    public int fun( int i, int prev, int[] nums, int k){
          if(i==nums.length) return 0;
          if (dp[i][prev+1][k] != -1) {
            return dp[i][prev+1][k];
        }
      
        int c1 = fun(i+1,prev,nums,k);

        int c2 = 0;

        if(prev==-1){
            c2 = 1+fun(i+1,i,nums,k);
        }

        else if(nums[prev]  == nums[i]){
            c2 = 1+fun(i+1,i,nums,k);
        }
        else if(k>0){
            c2 = 1+fun(i+1,i,nums,k-1);
        }
    return dp[i][prev+1][k]=Math.max(c1,c2);
        
    }
}