class Solution {
    public int maxFrequencyElements(int[] nums) {
        int arr[] = new int[101];

        int maxFreq = 0;
        for(int ele : nums){
            arr[ele]++;

            maxFreq = Math.max(maxFreq, arr[ele]);
        }
        int count = 0;
        for(int ele : arr){
            if(ele == maxFreq){
                count = count + ele;
            }
        }
        return count;


    }
}