class Solution {


    class Pair implements Comparable<Pair>{
        char ch;
        int freq;

        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair p){
            if(this.freq > p.freq)  return -1;
            if(this.freq == p.freq && this.ch > p.ch)   return -1;
            return 1;
        }
    }

    public String frequencySort(String s) {
        
        // TreeMap<Character, 
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        Pair []p = new Pair[map.size()];

        int i = 0;
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int freq = e.getValue();
            char ch = e.getKey();
            p[i] = new Pair(ch, freq);
            i++;
        }

        Arrays.sort(p);

        String res = "";
        for(Pair p1 : p){
            int freq = p1.freq;
            char ch = p1.ch;

            while(freq -- > 0){
                res += ch;
            }
        }
        return res;

    }
}