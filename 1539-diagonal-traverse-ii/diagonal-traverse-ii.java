class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {


        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();


        int maxSum = 0;
        int total = 0;

        for(int i = 0;i<nums.size();i++){
            total += nums.get(i).size();
            for(int j = 0;j<nums.get(i).size();j++){
                int sum = i + j;
                maxSum = Math.max(maxSum, sum);
                // map.put(sum, map.getOrDefault(sum, new ArrayList<>()))
                if(map.containsKey(sum)){
                    ArrayList<Integer> list = map.get(sum);
                    list.add(0,nums.get(i).get(j));
                    map.put(sum, list);
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(sum,list);
                }
            }
        }
        // System.out.println(map);
        int index = 0;
        int res[] = new int[total];
        for(int i = 0;i<=maxSum;i++){
            ArrayList<Integer> list = map.get(i);
            int j = 0;
            while(j < list.size()){
                res[index] = list.get(j);
                index++;
                j++;
            }
        }

        return res;

    }
}