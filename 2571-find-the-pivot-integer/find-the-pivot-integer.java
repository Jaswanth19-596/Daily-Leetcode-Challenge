class Solution {
    public int pivotInteger(int n) {
        
        int leftsum = 0;


        int total = 0;

        total = (n * (n+1))/2;

        for(int pivot = 1;pivot<=n;pivot++){
            leftsum += pivot;

            int rightsum = total - leftsum + pivot;

            if(leftsum == rightsum){
                return pivot;
            }
        }

        return -1;


    }
}