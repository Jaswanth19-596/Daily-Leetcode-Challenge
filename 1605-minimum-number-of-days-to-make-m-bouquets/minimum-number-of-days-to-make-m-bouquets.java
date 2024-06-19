class Solution {


    public int minDays(int[] bloomDay, int m, int k) {
        

        // I'll APply binary search on the bloomday.
        int min = 1;
        int max = (int)1e9;

        int res = -1;

        while(min <= max){

            int mid = min + (max - min)/2;

            int currentDay = mid;

            int bouques = 0;
            int flowers = 0;

// 50000
            int count = 0;

            for(int i = 0;i<bloomDay.length;i++){
                if(bloomDay[i] <= currentDay){
                    flowers++;
                    
                    if(flowers == k){
                        bouques++;
                        flowers = 0;
                    }
                }
                else{
                    flowers=0;
                }
            }

            if(bouques >= m){
                res = currentDay;
                max = currentDay - 1;
            }
            else{
                min = currentDay + 1;
            }


        }

        return res;
    }
}