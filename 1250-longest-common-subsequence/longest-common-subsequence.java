class Solution {    int getLongest(int i, int j, String str1, String str2, int dp[][]){

        if(i == str1.length() || j == str2.length())  return 0;

        if(dp[i][j] != -1)  return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)){
            return 1 + getLongest(i+1, j+1, str1, str2, dp);
        }

        int moveI = getLongest(i+1, j, str1, str2, dp);
        int moveJ = getLongest(i, j+1, str1, str2, dp);

        return dp[i][j] = Math.max(moveI, moveJ);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[1001][1001];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        return getLongest(0,0,text1, text2, dp);
    }
}