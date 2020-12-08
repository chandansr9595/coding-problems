class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){
            int[] res = new int[2];
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int[] res = new int[2];
        if( l > nums.length-1 || nums[l] != target ){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = l;
        for(int i=l; i<nums.length; i++){
            if(nums[i] != nums[l]){
                res[1] = i-1;
                break;
            }
            if(i == nums.length - 1){
                res[1] = i;
            }
        }
        return res;
    }
}