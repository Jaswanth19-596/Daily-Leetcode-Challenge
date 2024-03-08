class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];

        int count = 0, maxFreq = 0;

        for(int ele : nums){
            freq[ele] += 1;

            if(freq[ele] > maxFreq){
                maxFreq = freq[ele];
                count = maxFreq;
            }
            else if(freq[ele] == maxFreq){
                count += maxFreq;
            }
        }

        return count;
    }
}