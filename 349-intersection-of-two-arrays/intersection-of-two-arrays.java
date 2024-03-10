class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        int freq[] = new int[1001];

        for(int ele : nums1){
            freq[ele] = 1;
        }

        for(int ele : nums2){
            if(freq[ele] == 1){
                freq[ele]++;
                list.add(ele);
            }
        }

        int res[] = new int[list.size()];
        int i = 0;
        for(int ele : list){
            res[i++] = ele;
        }
        return res;
    }
}