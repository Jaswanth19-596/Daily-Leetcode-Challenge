class Solution {

    public boolean canIDoBouquets(int []bloomDay, int mid, int m, int k){

        int nBouquets = m;

        int i = 0;

        while(i < bloomDay.length){

            int flowers = 0;
            while(i<bloomDay.length){

                if(bloomDay[i] <= mid){
                    flowers++;
                }
                else{
                    flowers = 0;
                }


                if(flowers == k){
                    nBouquets--;
                    flowers = 0;
                }
                i++;
            }
        }

        if(nBouquets <= 0)  return true;
        return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        if( m * k > bloomDay.length)    return -1;

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 
        // If you can do the bouquets in nth day, then you can do it in N -> Inf days. Since we need minimum no of days, there's no point in going to next days.
        // We will store this answer as a temporary answer and try to do it in even more minimum no of days
        
        // If we cannot do the required bouquets on some xth day, that means, we cannot do it in x - 1 -> -INF.

        int low = 1, high = (int)1e9;

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean res = canIDoBouquets(bloomDay, mid, m, k);
            if(res){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}