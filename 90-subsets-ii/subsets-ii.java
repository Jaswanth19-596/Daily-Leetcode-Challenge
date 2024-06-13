class Solution {

    List<List<Integer>> list = new ArrayList<>();

    void func(int i, List<Integer> subset, int nums[]){

        if(i == nums.length){

            if(list.contains(subset)){
                return;
            }
            else{
                list.add(new ArrayList<>(subset));
            }
            return;
        }

        func(i+1, subset, nums);

        subset.add(nums[i]);

        func(i+1, subset, nums);

        subset.remove(subset.size()-1);
    }



    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        func(0, new ArrayList<>(), nums);
        return list;
    }
}