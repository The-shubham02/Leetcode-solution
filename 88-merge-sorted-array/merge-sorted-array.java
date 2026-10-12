class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = nums2.length-1;
        for(int i = nums1.length -1 ; i>=0; i--){
            if(nums1[i]!= 0) break;
              nums1[i] = nums2[j] ;
              j--;
                if(j==-1) break;
        }
        Arrays.sort(nums1);
        
    }
}