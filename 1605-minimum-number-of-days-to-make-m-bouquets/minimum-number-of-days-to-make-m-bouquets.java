class Solution {


    int getMin(int []arr){
        int res = Integer.MAX_VALUE;
        for(int ele : arr){
            res = Math.min(ele, res);
        }
        return res;
    }

    int getMax(int []arr){
        int res = Integer.MIN_VALUE;
        for(int ele : arr){
            res = Math.max(ele, res);
        }
        return res;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        

        // I'll APply binary search on the bloomday.
        // Min value and max value will be from bloomday.
        int min = getMin(bloomDay);
        int max = (int)1e9;

        int res = -1;

        while(min <= max){

            int mid = min + (max - min)/2;

            int currentDay = mid;

            int bouques = 0;
            int flowers = 0;


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