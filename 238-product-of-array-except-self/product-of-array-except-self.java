class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1, productWithoutZero = 1;

        int zeroCount = 0;

        for(int ele : nums){
            product = product * ele;

            if(ele != 0){
                productWithoutZero *= ele;
            }
            else{
                zeroCount++;
            }
        }

        int res[] = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            int ele = nums[i];
            if(ele == 0){
                if(zeroCount <= 1){
                    res[i] = productWithoutZero;
                 }
                 else{
                    res[i] = 0;
                 }
            }
            else{
                res[i] = product/ele;
            }
        }


        return res;

    }
}