class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int left = 0, right = nums.length - 1;

        int squares[] = new int[nums.length];

        int i = nums.length - 1;
        while(left <= right){

            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                squares[i] = nums[left] * nums[left];
                i--;
                left++;
            }
            else{
                squares[i] = nums[right] * nums[right];
                i--;
                right--;
            }        

        }
        return squares;


    }
}