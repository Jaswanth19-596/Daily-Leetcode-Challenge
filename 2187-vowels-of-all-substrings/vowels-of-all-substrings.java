class Solution {
    public long countVowels(String word) {
        long ans = 0;

        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                int temp = word.length();
                if(i == 0 || i== word.length()-1){
                    ans += temp;
                }
                else{
                    // itself
                    ans += 1;
                    // Ending with 
                    ans += i;
                    // starting with 
                    ans += (word.length() - i -1);

                    // in middle with
                    long left = i;
                    long right = (word.length() - i -1);

                    ans += (left * right);
                    
                }
            }
        }


        return ans;
    }
}