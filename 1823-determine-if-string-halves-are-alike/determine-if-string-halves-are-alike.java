class Solution {

    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }


    public boolean halvesAreAlike(String s) {

        s = s.toLowerCase();
        
        int vowelsInFirstHalf = 0, vowelsInSecondHalf = 0;

        for(int i = 0;i<s.length();i++){

            if(isVowel(s.charAt(i))){
                if(i < s.length()/2){
                    vowelsInFirstHalf++;
                }
                else{
                    vowelsInSecondHalf++;
                }
            }
        }
        return vowelsInFirstHalf == vowelsInSecondHalf;


    }
}