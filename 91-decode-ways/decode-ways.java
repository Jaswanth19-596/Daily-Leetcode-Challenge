class Solution {


    int dfs(int i, String s, int dp[]){

        if(i == s.length()) return 1;

        if(s.charAt(i) == '0')  return 0;

        if(i == s.length() - 1) return 1;

        if(dp[i] != -1) return dp[i];

        String str = "";
        int count = 0;
        for(int j = i;j<s.length();j++){
            char ch = s.charAt(j);
            str += ch;

            if(Integer.parseInt(str) > 26)  break;

            count += dfs(j+1, s,dp);
        }

        return dp[i] = count;
    }




    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return dfs(0,s,dp);
    }
}