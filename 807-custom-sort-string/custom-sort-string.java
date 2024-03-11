
   class MyComparator implements Comparator<Character>{
        Map<Character, Integer> map;

        MyComparator(Map<Character, Integer> map){
            this.map = map;
        }


        public int compare(Character  ch1, Character  ch2){
            if(map.get(ch1) < map.get(ch2)){
                return -1;
            }
            else if(map.get(ch1) > map.get(ch2)){
                return 1;
            }
            return 0;
        }
    }

class Solution {

     public String customSortString(String order, String s) {
       
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       int i = 0;
       for(char ch : order.toCharArray()){
           map.put(ch, i++);
       }

       for(char ch = 'a'; ch<='z';ch++){
           if(map.containsKey(ch) == false){
               map.put(ch, Integer.MAX_VALUE);
           }
       }

       Character[] ch = new Character[s.length()];
        for (int j = 0; j < s.length(); j++) {
            ch[j] = s.charAt(j);
        }

       Arrays.sort(ch, new MyComparator(map));
        String res = "";
       for(char c : ch){
           res += c;
       }      

       return res;

    }
}