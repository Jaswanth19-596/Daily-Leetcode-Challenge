class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {


        int count = 0;

        HashMap<Long,Integer> map1 = new HashMap<>();
        for(int i = 0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                long val = nums1[i] + nums2[j];
                map1.put(val, map1.getOrDefault(val,0)+1);
            }
        }
        // HashMap<Long,Integer> map2 = new HashMap<>();
        for(int i = 0;i<nums3.length;i++){
            for(int j = 0;j<nums4.length;j++){
                long val = nums3[i] + nums4[j];
                
                if(map1.containsKey(-val)){
                    count += map1.get(-val);
                }
            }
        }

        return count;

    }
}