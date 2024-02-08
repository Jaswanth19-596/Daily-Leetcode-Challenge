class Solution {


    class MyComparator implements Comparator<Pair>{

        public int compare(Pair p1, Pair p2){
            if(p1.freq > p2.freq)   return -1;
            if(p1.freq == p2.freq && p1.ch > p2.ch) return -1;
            return 1;
        }


    }


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



        PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int freq = e.getValue();
            char ch = e.getKey();
            pq.add(new Pair(ch, freq));
        }

        String res = "";

        while(pq.size() > 0){
            Pair p1 = pq.poll();
            int freq = p1.freq;
            char ch = p1.ch;

            while(freq-- > 0){
                res += ch;
            }
        }
        return res;

    }
}