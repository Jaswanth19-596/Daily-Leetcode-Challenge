class Solution {
    public long largestPerimeter(int[] nums) {

        long ans = 0;

        Arrays.sort(nums);

        int n = nums.length;

        long prefix[] = new long[n];
        prefix[0] = nums[0];

        for(int i = 1;i<n;i++){
            prefix[i] = nums[i] + prefix[i-1];
        }

        // start from behind
        for(int i = n - 1;i>=2;i--){
            // for every element go back and find the sum.
            long sidesSum = prefix[i-1];
            int largestSide = nums[i];

            if(largestSide < sidesSum)  return prefix[i];
        }
        return -1;
    }
}