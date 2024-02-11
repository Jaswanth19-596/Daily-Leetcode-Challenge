class MyComparator implements Comparator<int []>{
    public int compare(int []arr1, int []arr2){
        if(arr1[1] < arr2[1])   return -1;
        return 1;
    }
}


class Solution {

    int solve(int i, int prev, int [][]pairs){

        if(i == pairs.length)   return 0;

        int pick = 0;
        if(prev == -1 || pairs[prev][1] < pairs[i][0]){
            pick = 1 + solve(i + 1, i, pairs);
        }
        int notpick = solve(i+1, prev, pairs);

        return Math.max(pick, notpick);
    }


    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        Arrays.sort(pairs, new MyComparator());

        int dp[] = new int[n];
        int max = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max+1;
    }
}