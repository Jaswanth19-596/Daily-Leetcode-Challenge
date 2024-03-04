class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore = 0;
        int score = 0;
        int i = 0, j = tokens.length - 1;
        Arrays.sort(tokens);
        while(i<=j){
            while(i<=j && tokens[i] <= power){
                power = power - tokens[i];
                score++;
                maxScore = Math.max(score, maxScore);
                i++;
            }
            if(score < 1) return maxScore;

            power = power + tokens[j];
            score = score - 1;
            j--;
        }

        return maxScore;


    }
}