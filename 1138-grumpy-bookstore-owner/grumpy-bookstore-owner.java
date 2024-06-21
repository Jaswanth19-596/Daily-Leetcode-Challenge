class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int min) {
        
        int sum = 0;

        for(int ele : customers){
            sum += ele;
        }
        if(min >= grumpy.length){
            return sum;
        }



        int n = customers.length;
        int satisfied[] = new int[n];


        int totalSatisfied = 0;
        for(int i = 0;i<n;i++){
            if(grumpy[i] == 1){
                satisfied[i] = -customers[i];
            }
            else{
                satisfied[i] = customers[i];
                totalSatisfied += satisfied[i];
            }
        }

        int low = 0, high = 0;
        int unsatisfied = 0;
        int satisfiedInThisBlock = 0;
        while(high < min){

            if(satisfied[high] < 0){
                unsatisfied += Math.abs(satisfied[high]);
            }
            high++;
        }

        int res = totalSatisfied + unsatisfied;



        while(high < n){

            if(satisfied[low] < 0){
                unsatisfied += satisfied[low];
            }
            low++;

            if(satisfied[high] < 0){
                unsatisfied += Math.abs(satisfied[high]);
            }
            high++;

            res = Math.max(res, totalSatisfied + unsatisfied);
        }
        return res;






    }
}