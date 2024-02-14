class Solution {
    public int[] rearrangeArray(int[] nums) {

        int positive[] = new int[nums.length/2];
        int negative[] = new int[nums.length/2];

        int res[] = new int[nums.length];
        int i = 0, j = 0;
        for(int itr = 0;itr<nums.length;itr++){
            if(nums[itr] > 0 ){
                positive[i++] = nums[itr];
            }
            else{
                negative[j++] = nums[itr];
            }
        }
        boolean pos = true;

        i = 0;
        j = 0;
        for(int itr = 0;itr < nums.length;itr++){
            res[itr] = pos ? positive[i++] : negative[j++];
            pos = !pos;
        }
        return res;


    }
}