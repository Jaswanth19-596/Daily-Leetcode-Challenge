class Solution {

    public boolean sub(int i, int j, String s, String t){

        if(i == s.length()) return true;

        if(j == t.length()) return false;


        if(s.charAt(i) == t.charAt(j)){
            return sub(i+1,j+1,s,t);
        }

        return sub(i,j+1,s,t);
    }


    public boolean isSubsequence(String s, String t) {
        return sub(0,0,s,t);
    }
}