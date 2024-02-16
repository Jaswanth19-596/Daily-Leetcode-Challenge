class Solution {

    class Pair implements Comparable<Pair>{
        int ele, freq;

        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p){
            if(this.freq < p.freq)  return -1;
            if(this.freq > p.freq)  return 1;
            return 0;
        }
    }


    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        int count = 0;

        while(k>0){
            Pair p = pq.peek();
            if(p.freq > k)  return pq.size();
            pq.poll();
            count++;
            k -= p.freq;
        }

        return pq.size();


    }
}