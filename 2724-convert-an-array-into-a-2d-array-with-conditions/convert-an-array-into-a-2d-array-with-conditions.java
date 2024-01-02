class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int ele : nums){

            if(map.containsKey(ele)){
                int prev = map.get(ele);
                prev++;
                map.put(ele, prev);
                max = Math.max(max, prev);
            }
            else{
                map.put(ele, 1);
                max = Math.max(max, 1);
            }

        }
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0;i<max;i++){
            list.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()){

            int ele = e.getKey();
            int val = e.getValue();


            for(int i = 0;i<val;i++){
                list.get(i).add(ele);
            }
        }

        return list;
    }
}