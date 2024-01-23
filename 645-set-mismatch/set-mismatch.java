class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actualSum = (n * (n+1))/2;

        int currentSum = 0;

        boolean []visited = new boolean[nums.length+1];

        int repeating = 0;

        for(int ele : nums){

            if(visited[ele] == true){
                repeating = ele;
                continue;
            }

            visited[ele] = true;
            currentSum += ele;
        }

        return new int[] {repeating, actualSum - currentSum};
    }
}