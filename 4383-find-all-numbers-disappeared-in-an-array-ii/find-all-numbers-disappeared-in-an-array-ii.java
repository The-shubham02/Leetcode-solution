
import java.util.*;

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        long prev = (long) lower - 1;

        for (int x : nums) {
            if (x < lower || x > upper) {
                continue;
            }

            if (x <= prev) {
                continue;
            }

            if ((long) x - prev > 1) {
                ans.add(Arrays.asList((int)(prev + 1), x - 1));
            }

            prev = x;
        }

        if (prev < upper) {
            ans.add(Arrays.asList((int)(prev + 1), upper));
        }

        return ans;
    }
}
