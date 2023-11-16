class Solution {

    Set<String> set;
    String res = "";

    private boolean generate(int len, String str){

        if(len == 0){
            if(set.contains(str) == false){
                res = str;
                return true;
            }  
            return false;
        }
        boolean res = generate(len - 1, str + '0');

        if(res) return res;

        return generate(len - 1, str + '1');
    }


    public String findDifferentBinaryString(String[] nums) {
        
        set = new HashSet<>();

        for(String str : nums){
            set.add(str);
        }

        generate(nums.length, "");

        return res;

    }
}