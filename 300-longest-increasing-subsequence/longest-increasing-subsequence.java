class Solution {

    private int solve(int i, int prev, int []nums, int [][]dp){

        if(i == nums.length)    return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        if(prev == -1 || nums[i] > nums[prev]){
            // I have two options and I have to return the maximum of both answers
            int pick = 1 + solve(i+1, i, nums, dp);
            int notPick = 0 + solve(i + 1, prev, nums, dp);
            dp[i][prev+1] = Math.max(pick, notPick);
            // map.put(i+" "+prev, Math.max(pick, notPick));
            return Math.max(pick, notPick);
        }
        else{
            // You only have one option and you have to return that only option
            int res =  solve(i+1, prev, nums, dp);
            dp[i][prev+1] = res;
            return res;
        }
    }

    public int lengthOfLIS(int[] nums) {
        // Map<String, Integer> map = new HashMap<>();
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, -1, nums, dp);
    }
}