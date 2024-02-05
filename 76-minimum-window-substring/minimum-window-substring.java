class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray())  map.put(ch, map.getOrDefault(ch, 0)+1);


        int start = 0, end = 0, req = t.length();

        int finalIndex = -1, minLength = Integer.MAX_VALUE;

        while(end < s.length()){

            char ch = s.charAt(end);

            // Is it the character that i need
            if(map.containsKey(ch)){

                // I got one
                map.put(ch, map.get(ch) - 1);

                // If it is not a extra character then only reduce the required
                if(map.get(ch) >= 0){
                    req--;
                }
            }

            while(start <= end && req == 0){
                char ch1 = s.charAt(start);

                if(end - start < minLength){
                    finalIndex = start;
                    minLength = end - start + 1;
                }

                // if it is the character that we need
                if(map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1) + 1);

                    if(map.get(ch1) > 0){
                        req++;
                    }
                }
                start++;
            }
            end++;
        }

        

        if(finalIndex == -1)    return "";

        return getString(finalIndex, minLength, s);
    }

    String getString(int i, int len, String s){
        String res = "";

        for(int j = i;j<len+i;j++){
            res += s.charAt(j);
        }
        return res;
    }
}