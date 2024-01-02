class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<Set<Integer>> list = new ArrayList<>();


        for(int ele : nums){

            boolean inserted = false;

            for(Set<Integer> set : list){
                if(set.contains(ele) == false){
                    set.add(ele);
                    inserted = true;
                    break;
                }
            }

            if(inserted == false){
                Set<Integer> set = new HashSet<>();
                set.add(ele);
                list.add(set);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(Set<Integer> set : list){
            res.add(new ArrayList<>(set));
        }


        return res;
    }
}