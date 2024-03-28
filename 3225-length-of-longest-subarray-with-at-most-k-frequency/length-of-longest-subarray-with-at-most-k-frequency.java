class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int maxLength = 0, i = 0, j = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        while(j < n){
            int ele = nums[j];
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            while(map.get(ele) > k){
                int ele2 = nums[i];
                int prevFreq = map.get(ele2);
                prevFreq--;
                i++;
                map.put(ele2, prevFreq);
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;




    }
}