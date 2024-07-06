class Solution {
    public int passThePillow(int n, int time) {
       
        int direction = 1;

        int arr[] = new int[n+1];

        int i = 1;

        while(time > 0){

            if(direction == 1){
                i++;
            }
            else{
                i--;
            }

            if(i == n){
                direction = -1;
            }
            if(i == 1){
                direction = 1;
            }
            time--;
        }

        return i;


    }
}