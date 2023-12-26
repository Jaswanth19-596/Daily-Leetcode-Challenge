class Solution {

    private static final int MOD = 1000000007;

    int solve(int arr[], int dice, int faces, int target, int dp[][]){

        if(dice == arr.length){
            if(target == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(target < 0)  return 0;

        if(dp[dice][target] != -1)  return dp[dice][target];

        int res = 0;

        for(int i = 1;i<=faces;i++){
            res = (res + solve(arr, dice + 1, faces, target - i, dp))%MOD;
        }

        return dp[dice][target] = res;


    }



    public int numRollsToTarget(int n, int k, int target) {
        int arr[] = new int[n];
        int dp[][] = new int[n+1][target+1];

        for(int brr[] : dp){
            Arrays.fill(brr, -1);
        }

        return solve(arr, 0, k, target, dp);
    }
}