class Solution {

    public int solve(int i, int prev, boolean visited[], int [][]pairs, int dp[][]){

        if(i == visited.length) return 0;
        if(i < 0)   return 0;

        if(visited[i] == true)  return solve(i+1, prev, visited, pairs, dp);

        if(dp[i][prev+1] != -1) return dp[i][prev+1];


        int pick = 0;
        int notpick = 0;
        notpick = solve(i+1, prev, visited, pairs, dp);
       
        if(prev == -1 || pairs[prev][1] < pairs[i][0]){
            visited[i] = true;
            pick = 1 + solve(i+1, i, visited, pairs, dp);
            int goBack = 1 + solve(0, i, visited, pairs, dp);
            pick = Math.max(pick, goBack);
            visited[i] = false;
        }
       
        return dp[i][prev + 1] = Math.max(pick, notpick);
    }



    public int findLongestChain(int[][] pairs) {
        int prev = -1;

        int dp[][] = new int[1001][1001];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        boolean visited[] = new boolean[pairs.length];

        return solve(0, prev, visited, pairs, dp);
    }
}