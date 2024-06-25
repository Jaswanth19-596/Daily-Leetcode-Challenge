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

        if((mid - 1 >= 0 && arr[mid] > arr[mid - 1]) && (mid + 1 < arr.length && arr[mid] > arr[mid + 1])){
            return mid;
        }
        else if(mid +1 < arr.length && arr[mid] > arr[mid + 1]){
            return peak(low, mid - 1, arr);
        }
        return peak(mid + 1, high, arr);
    }


    public int findPeakElement(int[] nums) {
        return peak(0, nums.length - 1, nums);
    }
}