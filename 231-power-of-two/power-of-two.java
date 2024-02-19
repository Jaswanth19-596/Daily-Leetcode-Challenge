class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n <= 0)  return false;

        int ele = 1;

        for(int i = 1;i<=31;i++){
            if(ele == n)    return true;
            ele = ele * 2;
        }

        return false;
    }
}