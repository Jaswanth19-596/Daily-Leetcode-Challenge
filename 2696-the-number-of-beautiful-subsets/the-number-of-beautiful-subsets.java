class Solution {

    public int func(int i, HashSet<Integer> set, int []nums, int k){
        if(i == nums.length){
            if(set.size() == 0)  return 0;
            return 1;
        }       

        int notpick = func(i+1, set, nums, k);


        if(set.contains(nums[i] - k)) return notpick;

        set.add(nums[i]);
        notpick += func(i+1, set, nums, k);
        set.remove(nums[i]);

        return notpick;
    }


    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return func(0, new HashSet<Integer>(), nums, k);
    }
}