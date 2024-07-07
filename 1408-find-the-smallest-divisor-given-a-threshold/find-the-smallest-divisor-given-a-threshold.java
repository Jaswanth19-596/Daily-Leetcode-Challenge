class Solution {

    boolean isLessThanThreshold(int nums[], int mid, int threshold){
        int sum = 0;
        for(int ele : nums){
            sum += (int)Math.ceil((double)ele/(double)mid);
        }

        if(sum <= threshold)    return true;
        return false;
    }



    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = (int)1e6;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(isLessThanThreshold(nums, mid, threshold)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;


    }
}