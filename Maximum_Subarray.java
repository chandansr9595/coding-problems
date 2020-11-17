class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = nums[0];
        for(int i=1; i< nums.length; i++) {
            currSum = nums[i] + currSum;
            if(nums[i] > currSum) {
                currSum = nums[i];
            }
            if(currSum > sum){
                sum = currSum;
            }
        }
        return sum;
    }
}