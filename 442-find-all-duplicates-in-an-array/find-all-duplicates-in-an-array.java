class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        if(nums.length == 1)    return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0;i<nums.length;i++){
            int ele = Math.abs(nums[i]) - 1;

            if(nums[ele] < 0){
                res.add(ele+1); 
            }
            else{
                nums[ele] = -nums[ele];
            }
        }


        return res;


    }
}