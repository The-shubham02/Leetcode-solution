
class Solution {
    public int maxSubArray(int[] nums) {
        int prefix = 0;
        int minPrefix = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            prefix += num;

            maxSum = Math.max(maxSum, prefix - minPrefix);

            minPrefix = Math.min(minPrefix, prefix);
        }

        return maxSum;
    }
}
