class Solution {
    public int bagOfTokensScore(int[] token, int power) {
        int score = 0;
        int i = 0, j = token.length - 1;
        int maxScore = 0;

        Arrays.sort(token);

        while(i<=j){

            // I will always try to play it as A
            while(i<=j && token[i] <= power){
                power = power - token[i];
                score += 1;
                maxScore = Math.max(score, maxScore);
                i++;
            }

            // I will try to play it as B
            if(score < 1)   return maxScore;

            power = power + token[j];
            score = score - 1;
            j--;
        }

        return maxScore;
    }
}