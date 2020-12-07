class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        if(i >= 0){
            int j = n-1;
            while(j>1 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    
    private void swap(int nums[], int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
    
    private void reverse(int nums[], int lo, int hi){
        while(lo < hi){
            swap(nums, lo++, hi--);
        }
    }
}