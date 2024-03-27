class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int i = 0, j = 0, ans = 0;
        int n = nums.length;

        while(j < n){

            product = product * nums[j];

            while(i < j && product >= k){
                product = product / nums[i];
                i++;
            }

            if(product < k){
                ans += (j - i + 1);
            }

            j++;
        }


        return ans;
    }
}