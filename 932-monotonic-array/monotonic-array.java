class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1)    return true;

        int n = nums.length;

        boolean increasing = true, decreasing = true;
        int i = 1;
        while( i < n ){
            if(nums[i-1] < nums[i]){
                decreasing = false;
            }
            if(nums[i-1] > nums[i]){
                increasing = false;
            }
            i++;
        }
        return decreasing || increasing;
    }
}