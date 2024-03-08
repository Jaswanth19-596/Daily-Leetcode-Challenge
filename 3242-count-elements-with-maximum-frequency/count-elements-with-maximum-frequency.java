class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];

        int maxFreq = 0, count = 0;

        for(int ele : nums){
            freq[ele]++;

            if(freq[ele] > maxFreq){
                maxFreq = freq[ele];
                count = freq[ele];
            }
            else if(freq[ele] == maxFreq){
                count = count + freq[ele];
            }
        }

        return count;
    }
}