class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                ones += 1;
            }
        }

        String str = "";

        for(int i = 0;i<ones-1;i++){
            str += '1';
        }

        for(int i = str.length();i<s.length()-1;i++){
            str += '0';
        }

        str += '1';
        return str;
    }
}