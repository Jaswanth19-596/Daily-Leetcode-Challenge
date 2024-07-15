class Solution {


    boolean canShip(int capacity, int []weights, int days){

        int daysRequired = 0;

        int currentWeight = 0;

        for(int ele : weights){
            currentWeight += ele;

            if(currentWeight > capacity){
                daysRequired++;
                currentWeight = ele;
            }

            if(currentWeight > capacity)    return false;

        }
        if(currentWeight > 0){
            daysRequired++;
        }

        if(daysRequired <= days){
            return true;
        }
        return false;
    }



    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max =  5 * (int)(1e4) * 500 + 1;

        int ans = max;

        while(min <= max){
            int mid = min + (max - min)/2;

            if(canShip(mid, weights, days)){
                ans = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }

        return ans;



    }
}