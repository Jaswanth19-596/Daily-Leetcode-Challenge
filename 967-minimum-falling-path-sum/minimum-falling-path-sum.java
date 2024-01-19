class Solution {

    int func(int i, int j, int [][]matrix, int dp[][]){

        if(j < 0 || j == matrix[0].length)   return 100000;

        if(i == matrix.length - 1)  return matrix[i][j];

        if(dp[i][j] != -100000)  return dp[i][j];

        int option1 = matrix[i][j] + func(i+1, j-1, matrix, dp);
        int option2 = matrix[i][j] + func(i+1,j, matrix, dp);
        int option3 = matrix[i][j] + func(i+1, j+1, matrix, dp);

        return dp[i][j] = Math.min(Math.min(option1, option2), option3);
    }


    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;

        int dp[][] = new int[101][101];


        for(int arr[] : dp) Arrays.fill(arr, -100000);

        for(int j = 0;j<matrix[0].length;j++){
            int res = func(0,j,matrix, dp);
            ans = Math.min(ans, res);
        }    

        return ans;
    }
}