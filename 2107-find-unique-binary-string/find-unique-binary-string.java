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
        
//         set = new HashSet<>();

//         for(String str : nums){
//             set.add(str);
//         }

//         // generate(nums.length, "");      
//         return res;
        
        
        Set<Integer> set1 = new HashSet<>();
        for(String str : nums){
            set1.add(Integer.parseInt(str,2));
        }
        
        // System.out.println(set1);
        
        for(int i = 0;i<=nums.length;i++){
            if(set1.contains(i) == false){
                
                String res = Integer.toBinaryString(i);
                int n = res.length();
                
                for(int j = 0;j<nums.length-n;j++){
                    res = '0'+res;
                
                }
                return res;
                
            }
        }
        
        return "";
        
        
        
        
        

    }
}