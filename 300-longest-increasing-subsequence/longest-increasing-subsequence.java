class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tmp = new int[nums.length];
        int size = 0;

        for (int a : nums) {
            if (size == 0 || a > tmp[size - 1]) {
                tmp[size] = a;
                size++;
            } else {
                for (int j = 0; j < size; j++) {
                    if (tmp[j] >= a) {
                        tmp[j] = a;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(tmp[i] + " ");
        }

        return size;
    }
}