class Solution {



    int peak(int low, int high, int []arr){
        if(high < 0){
            return 0;
        }
        if(low > arr.length){
            return arr.length;
        }

        if(low == high){
            return low;
        }

        int mid = (low + high)/2;

        if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
            return mid;
        }
        else if(arr[mid] > arr[mid + 1]){
            return peak(low, mid - 1, arr);
        }
        return peak(mid + 1, high, arr);
    }


    public int findPeakElement(int[] nums) {

        if(nums.length == 1){
            return 0;
        }

        if(nums[0] > nums[1]){
            return 0;
        }
        int n = nums.length;

        if(nums[n-1] > nums[n-2])   return n-1;


        return peak(1, nums.length - 2, nums);
    }
}