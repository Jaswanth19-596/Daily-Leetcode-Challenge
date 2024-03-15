class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int prefix[] = new int[n];
        int suffix[] = new int[n];

        // prefix[0] = 1;
        // for(int i = 1;i<n;i++){
        //     prefix[i] = prefix[i-1] * nums[i-1];
        // }

        suffix[n-1] = 1;

        for(int i = n-2;i>=0;i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int prefix = 1;

        for(int i = 1;i<=n;i++){
            suffix[i - 1] = suffix[i-1] * prefix;
            prefix = prefix * nums[i-1];
        }

        return suffix;




    }
}