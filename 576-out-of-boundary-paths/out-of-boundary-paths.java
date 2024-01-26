class Solution {
    
    
    long pushBall(int i, int j, int max, int m, int n, long dp[][][]){
        
        if(i == m || j == n || i < 0 || j < 0)    return 1;
        if(max == 0)    return 0;

        if(dp[i][j][max] != -1) return dp[i][j][max];
        
        long up = pushBall(i-1, j, max-1, m, n, dp)%(long)(1e9);
        long right = pushBall(i, j + 1, max - 1, m, n, dp)%(long)(1e9);
        long down = pushBall(i+1, j, max - 1, m, n, dp)%(long)(1e9);
        long left = pushBall(i, j-1, max - 1, m, n, dp)%(long)(1e9);
        
        return dp[i][j][max] =((long)up + (long)right+ (long)down + (long)left) % (long)(1e9+7);
    }
    
    
    
    
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][] = new long[m+1][n+1][maxMove+1];

        for(long mat[][] : dp){
            for(long arr[] : mat){
                Arrays.fill(arr, -1);
            }
        }

        return (int)pushBall(startRow, startColumn, maxMove, m, n, dp);
    }
}