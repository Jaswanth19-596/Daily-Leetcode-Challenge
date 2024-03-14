class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            int ele = nums[i];

            if(ele > sum + ele){
                sum = ele;
            }
            else{
                sum = sum + ele;
            }

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;



    }
}