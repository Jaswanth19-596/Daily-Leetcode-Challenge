class Solution {
    public boolean closeStrings(String word1, String word2) {


        if(word1.length() != word2.length())    return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char ch : word1.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for(char ch : word2.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }



        HashMap<Integer, Integer> map3 = new HashMap<>();
        HashMap<Integer, Integer> map4 = new HashMap<>();
        
        for(Map.Entry<Character,Integer> e : map1.entrySet()){
            char key = e.getKey();
            int value = e.getValue();

            if(map2.containsKey(key) == false)  return false;

            map3.put(value, map3.getOrDefault(value, 0)+1);
        }
        for(Map.Entry<Character,Integer> e : map2.entrySet()){
            char key = e.getKey();
            int value = e.getValue();

            map4.put(value, map4.getOrDefault(value, 0)+1);
        }   
        for(Map.Entry<Integer,Integer> e : map3.entrySet()){
            int key = e.getKey();
            int value = e.getValue();


           if(map4.containsKey(key) == false || map4.get(key) != value)   return false;
        }   
        return true;


    }
}