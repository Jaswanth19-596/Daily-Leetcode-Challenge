class Solution {


    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sortColors(int[] nums) {

        int ptr = 0, zeroesptr = -1, twosptr = nums.length-1;

        while(twosptr >= 0 && nums[twosptr] == 2){
            twosptr--;
        }

        while(ptr <= twosptr){

            if(nums[ptr] == 1){
                ptr++;
            }
            else if(nums[ptr] == 2){
                swap(nums, twosptr, ptr);
                twosptr--;
            }
            else{
                zeroesptr++;
                swap(nums, zeroesptr, ptr);
                ptr++;
            }
        }

        // return nums;

    }
}