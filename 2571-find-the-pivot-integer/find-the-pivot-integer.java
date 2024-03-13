class Solution {
    public int pivotInteger(int n) {
        int total = 0;

        total = (n * (n+1))/2;

        int sum = 0;

        for(int i = 1;i<=n;i++){
            sum += i;

            int rem = i + total - sum;

            if(sum == rem){
                return i;
            }
        }

        return -1;
    }
}