class Solution {
    public int majorityElement(int[] nums) {
        
        int maj = 0, count = 0;

        for(int ele : nums){
            if(count == 0){
                maj = ele;
                count = 1;
            }
            else if(maj == ele){
                count++;
            }
            else{
                count--;
            }
        }
        return maj;

    }
}