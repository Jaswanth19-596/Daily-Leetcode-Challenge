class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int maxTime = 0;

        for(int ele : left){
            maxTime = Math.max(ele,maxTime);
        }

        for(int ele : right){
            maxTime = Math.max(n - ele, maxTime);
        }

        return maxTime;


    }
}