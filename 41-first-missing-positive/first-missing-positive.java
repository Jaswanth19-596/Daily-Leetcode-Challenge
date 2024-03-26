class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // for(int i = 0;i<nums.length;i++){
            
        // }

        int i = 0;

        while(i < nums.length){
            if(nums[i] > nums.length || nums[i] <=0){
                i++;
                continue;
            }

            if(nums[i] == i+1){
                i++;
                continue;
            }

            if(nums[i] == nums[nums[i]-1]){
                i++;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[temp-1];
            nums[temp-1] = temp;
        }

        for(i = 0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;

    }
}