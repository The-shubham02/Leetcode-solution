class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        
        for (int num : nums) {
            int digits = 0;
            while (num > 0) {
                num /= 10;
                digits++;
            }
            if (digits % 2 == 0) {
                evenCount++;
            }
        }
        
        return evenCount;
    }
}
