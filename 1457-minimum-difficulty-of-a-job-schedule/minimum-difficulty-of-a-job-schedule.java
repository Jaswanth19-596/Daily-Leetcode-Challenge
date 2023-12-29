class Solution {


    public int solve(int ind, int days, int arr[], int dp[][]){
        if(days == 0){
            if(ind == arr.length){
                return 0;
            }
            else{
                return 100000;
            }
        }

        if(ind == arr.length)   return 100000;

        if(dp[ind][days] != -1) return dp[ind][days];

        int max = arr[ind];
        int res = Integer.MAX_VALUE;

        for(int j = ind;j < arr.length;j++){

            max = Math.max(max, arr[j]);

            int ans = solve(j+1, days - 1, arr, dp);

            if(ans != -1){
                ans = max + ans;
                res = Math.min(res, ans);
            }else{
                
            }           
        }


        return dp[ind][days] = res == Integer.MAX_VALUE ? 0 : res;
    }


    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length)   return -1;
        int dp[][] = new int[jobDifficulty.length + 1][d+1];

        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }


        return solve(0,d,jobDifficulty, dp);
    }
}