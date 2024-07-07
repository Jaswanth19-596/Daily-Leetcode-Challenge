class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int ans = numBottles;

        int full = 0, empty = numBottles;

        while(empty >= numExchange){
            full = empty / numExchange;
            empty = empty % numExchange;

            ans += full;
            empty += full;
        }

        return ans;

        

        
    }
}