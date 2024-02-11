
class MyComparator implements Comparator<String>{

    public int compare(String str1, String str2){
        if(str1.length() < str2.length())   return -1;
        if(str2.length() < str1.length())   return 1;
        return 0;
    }

}


class Solution {


    boolean check(String str1, String str2){

        int i = 0, j = 0;

        if(Math.abs(str1.length() - str2.length()) != 1)    return false;

        while(j<str1.length() && i<str2.length()){
            if(str1.charAt(j) == str2.charAt(i)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j == str1.length() ? true : false;

    }



    int solve(int i, int prev, String words[], int dp[][]){
        if(i == words.length)   return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        //pick
        int pick = 0;

        if(prev == -1 || check(words[prev], words[i])){
            pick = 1 + solve(i+1, i, words, dp);
        }

        int nopick = 0 + solve(i+1, prev, words, dp);

        return dp[i][prev + 1] = Math.max(pick, nopick);

    }


    public int longestStrChain(String[] words) {
        Arrays.sort(words, new MyComparator());

        int dp[][] = new int[1001][1001];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return solve(0, -1, words, dp);
    }
}