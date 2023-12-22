class Solution {
    public int maxScore(String s) {
        
        int zeros = 0;
        
        int ones = 0;
        
        for(char ch : s.toCharArray()){
            if(ch - '0' == 1){
                ones+=1;
            }
        }
        int res = 0;


        for(int i = 0;i<s.length()-1;i++){
            char ch = s.charAt(i);

            if(ch == '0'){
                zeros++;
            }
            else{
                ones--;
            }
            res = Math.max(zeros + ones,res);
        }

    
        
        return res;       
        
    }
}