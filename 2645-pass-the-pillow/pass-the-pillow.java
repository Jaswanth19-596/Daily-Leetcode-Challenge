class Solution {
    public int passThePillow(int n, int time) {
        
        time = time % ((2 * n) - 2);

        if(time < n){
            return 1 + time;
        }
        else{
            time = time - n + 1;
            return n - time;
        }

    }
}