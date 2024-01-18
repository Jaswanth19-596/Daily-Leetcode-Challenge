class Solution {


    int func(int step, int n, int dp[]){

        if(step == n)   return 1;

        if(step > n)    return 0;

        if(dp[step] != -1) return dp[step];


        int oneStep = func(step + 1, n, dp);
        int twoSteps = func(step + 2 , n, dp);

        return dp[step] = oneStep + twoSteps;

    }

    public int climbStairs(int n) {
        int dp[] = new int[n+1];

        Arrays.fill(dp, -1);

        return func(0, n, dp);
    }
}