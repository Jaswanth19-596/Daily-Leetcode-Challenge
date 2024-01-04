class Solution {
    public int minOperations(int[] nums) {
        
        int ans = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int freq = e.getValue();

            if(freq == 1)   return -1;

            ans += (int)Math.ceil((double)freq/(double)3);
        }
        return ans;



    }
}