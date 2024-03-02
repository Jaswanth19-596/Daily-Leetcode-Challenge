class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int res[] = new int[n];

        int index = n - 1;

        int i = 0, j = n - 1;

        while( i <= j){

            int ele1 = nums[i] * nums[i];
            int ele2 = nums[j] * nums[j];
            if(ele1 > ele2){
                res[index] = ele1;
                i++;
            }
            else{
                res[index] = ele2;
                j--;
            }
            index--;
        }

        return res;        
    }
}