class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        

        int initialSatisfaction = 0;

        for(int i = 0;i<customers.length;i++){
            if(grumpy[i] !=1 ){
                initialSatisfaction += customers[i];
            }
        }

        int windowSatisfaction = 0;

        int low = 0, high = 0;

        while(high < minutes){
            
            if(grumpy[high] == 1){
                windowSatisfaction += customers[high];
            }

            high++;
        }


        int totalCustomersSatisfied = initialSatisfaction + windowSatisfaction;

        while(high < customers.length){

            if(grumpy[high] == 1){
                windowSatisfaction += customers[high];
            }
            high++;

            if(grumpy[low] == 1){
                windowSatisfaction -= customers[low];
            }
            low++ ;

            totalCustomersSatisfied = Math.max(totalCustomersSatisfied, initialSatisfaction + windowSatisfaction);
        }

        return totalCustomersSatisfied;





    }
}