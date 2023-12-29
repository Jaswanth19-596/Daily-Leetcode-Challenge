class Solution {

    public int solve(int index, int days, int arr[], int dp[][]){
       if(days == 1){

           int temp = 0;

           for(int i = index;i<arr.length;i++){
               temp = Math.max(temp, arr[i]);
           }
           return temp;
       }

        if(dp[index][days] != -1)   return dp[index][days];

        int maxEffort = arr[index];

        int res = Integer.MAX_VALUE;

        for(int i = index;i <= arr.length - days;i++){

            maxEffort = Math.max(maxEffort, arr[i]);

            int ans = solve(i+1,days - 1, arr, dp);
            
            res = Math.min(res, ans + maxEffort);
            
        }

        return dp[index][days] = res;
    }


    public int minDifficulty(int[] jobDifficulty, int d) {

        if(d > jobDifficulty.length)    return -1;

        int dp[][]  = new int[jobDifficulty.length + 1][d+1];

        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0,d,jobDifficulty, dp);
    }
}