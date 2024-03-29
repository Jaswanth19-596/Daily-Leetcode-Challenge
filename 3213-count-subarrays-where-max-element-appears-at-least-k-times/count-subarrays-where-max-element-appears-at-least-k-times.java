class Solution {

    int findMax(int []nums){
        int max = 0;

        for(int ele : nums){
            max = Math.max(ele, max);
        }
        return max;
    }

    public long countSubarrays(int[] nums, int k) {
        int max = findMax(nums);

        long count = 0;

        int n = nums.length;

        int i = 0, j = 0;

        Map<Integer,Integer> map = new HashMap<>();

        map.put(max, 0);

        while(j < n){

            int ele = nums[j];

            map.put(ele, map.getOrDefault(ele, 0)+1);

            while(i < n && map.get(max) >= k){

                int ele2 = nums[i];
                count += n - j;
                map.put(ele2, map.get(ele2)-1);
                i++;
            }
            j++;
        }

        return count;


    }
}