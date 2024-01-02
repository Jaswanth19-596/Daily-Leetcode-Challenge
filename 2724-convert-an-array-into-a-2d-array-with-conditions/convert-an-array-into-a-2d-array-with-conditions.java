class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<Set<Integer>> res = new ArrayList<>();


        for(int ele : nums){

            boolean inserted = false;

            for(Set<Integer> set : res){
                if(set.contains(ele) == false){
                    set.add(ele);
                    inserted = true;
                    break;
                }
            }

            if(inserted == false){
                Set<Integer> set = new HashSet<>();
                set.add(ele);
                res.add(set);
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for(Set<Integer> set : res){
            list.add(new ArrayList<>(set));
        }

        return list;
    }
}