class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length-1;
        int r = nums2.length-1;
        while(r>=0){
            nums1[l] = nums2[r];
            l--;r--;
        }
        Arrays.sort(nums1);
    }
}