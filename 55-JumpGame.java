class Solution {
    public boolean canJump(int[] nums) {
        int toReach = nums.length - 1;
        for(int i=nums.length-2; i>=0 ; i--){
            if(i + nums[i] >= toReach){
                toReach = i;
            }
        }
        return (toReach == 0 ? true : false);
    }
}