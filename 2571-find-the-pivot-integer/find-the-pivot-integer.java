class Solution {
    public int pivotInteger(int n) {
        

        for(int pivot = 1;pivot <= n;pivot++){

            int leftsum = 0;

            for(int i = 1;i<=pivot;i++){
                leftsum+=i;
            }

            int rightsum = 0;

            for(int i = pivot;i<=n;i++){
                rightsum += i;
            }

            if(leftsum == rightsum){
                return pivot;
            }
        }

        return -1;

    }
}