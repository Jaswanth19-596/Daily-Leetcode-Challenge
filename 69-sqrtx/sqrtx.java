class Solution {
    public int mySqrt(int x) {
        
        long low = 0, high = x;
        long ans = x;

        while(low <= high){
            long mid = (low + high)/2;

            if(mid * mid == x){
                return (int)mid;
            }
            else if(mid * mid < x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int)ans;
    }
}