class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n <= 0)  return false;

        int itr = 1;

        for(int i = 1;i<32;i++){
            if(n == itr)    return true;
            itr = itr * 2;
        }

        return false;
    }
}