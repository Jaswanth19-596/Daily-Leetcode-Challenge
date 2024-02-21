class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        if((left & (left - 1)) == 0){
            if(((long)2 * (long)left) == (long)right+1)    return left;
        }
        

        long x = Integer.MAX_VALUE;
        long i = left;
        int count = 0;
        while(i <= right){
            x &= i;
            if(x == 0)  return 0;
            i++;
        }
        return (int)x;

    }
}