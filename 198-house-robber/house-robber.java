class Solution {


    int func(int i, int nums[], int dp[]){
        
        if(i >= nums.length)    return 0;

        if(dp[i] != -1) return dp[i];

        int res = 0;
        for(int j = i+2;j<nums.length;j++){
            int ans = func(j, nums, dp);
            res = Math.max(ans, res);
        }
        return dp[i] = nums[i] + res;

    }



    public int rob(int[] nums) {
        int dp[] = new int[100];
        Arrays.fill(dp, -1);

        int startWithHouse1 = func(0, nums, dp);
        int startWithHouse2 = func(1, nums, dp);

        return Math.max(startWithHouse1, startWithHouse2);
    }
}