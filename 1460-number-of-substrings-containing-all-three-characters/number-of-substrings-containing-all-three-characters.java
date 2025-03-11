class Solution {
    public int numberOfSubstrings(String s) {
        
        int i = 0, j = 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        while(j < s.length()){
            char curr = s.charAt(j);

            map.put(curr, map.getOrDefault(curr, 0)+1);

            while(map.size() == 3){
                count += (s.length() - j);
                

                char prev = s.charAt(i);
                if(map.get(prev) == 1){
                    map.remove(prev);
                }
                else{
                    map.put(prev, map.getOrDefault(prev, 0)-1);
                }
                i++;
            }
            j++;

            
        }

        return count;


    }
}