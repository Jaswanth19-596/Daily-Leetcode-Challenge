class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();


        for(int i = 0;i<groupSizes.length;i++){

            if(map.containsKey(groupSizes[i])){
                ArrayList<Integer> list = map.get(groupSizes[i]);
                list.add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i],list);
            }


        }

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            int k = entry.getKey();
            ArrayList<Integer> list = entry.getValue();


            int i = 0;
            ArrayList<Integer> temp = new ArrayList<>();

            while(i < list.size()){
                temp.add(list.get(i));
                i++;
                if(temp.size() == k){
                    res.add(temp);
                    temp = new ArrayList<>();
                }
            }
        }
        return res;



    }
}