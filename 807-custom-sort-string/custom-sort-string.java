class Solution {
    public String customSortString(String order, String s) {
       
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        String res = "";
        for(char ch : order.toCharArray()){
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                for(int i = 0;i<freq;i++){
                    res = res + ch;
                }
                map.remove(ch);
            }
        }

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            char key = e.getKey();
            int value = e.getValue();

            for(int i = 0;i<value;i++){
                res = res + key;
            }
        }

        return res;


    }
}