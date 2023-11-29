class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;

        while(i < nums.length){
            if(nums[i] <=0 || nums[i] > nums.length){
                i++;
                continue;
            }

            if(nums[i] == nums[nums[i] - 1]){
                i++;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
            // i++;
        }
        System.out.println(Arrays.toString(nums));
        for(i = 0 ;i< nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;

    }
}