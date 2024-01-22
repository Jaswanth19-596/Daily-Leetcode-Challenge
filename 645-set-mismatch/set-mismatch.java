class Solution {
    public int[] findErrorNums(int[] nums) {
        
       Set<Integer> set = new HashSet<>();
        int max = nums.length;
        int []res = new int[2];

       for(int ele : nums){
           if(set.contains(ele)){
               res[0] = ele;
           }
           else{
               set.add(ele);
           }
       }


       for(int i = 1;i <= max;i++){
           if(set.contains(i) == false){
               res[1] = i;
               return res;
           }
       }

       return res;
    }
}