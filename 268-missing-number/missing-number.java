class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;

        for(int ele : nums) sum += ele;

        int total = (nums.length * (nums.length + 1))/2;

        return total - sum;

    }
}