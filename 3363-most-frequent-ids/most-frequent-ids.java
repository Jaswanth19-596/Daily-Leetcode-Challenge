class Solution {

    class Pair implements Comparable<Pair>{
        long ele, freq;

        Pair(long freq, long ele){
            this.freq = freq;
            this.ele = ele;
        }

        public int compareTo(Pair p){
            if(this.freq < p.freq){
                return 1;
            }
            else if(this.freq > p.freq){
                return -1;
            }
            return 0;
        }


    }


    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long res[] = new long[n];


        Map<Long, Long> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0;i<n;i++){
            long fre = freq[i];
            long ele = nums[i];

            if(map.containsKey(ele)){
                long prev = map.get(ele);
                prev += fre;
                map.put(ele, prev);
            }
            else{
                map.put(ele, fre);
            }

            // map.put(ele, map.getOrDefault(ele, 0l)+fre);
            pq.add(new Pair(map.get(ele), ele));

            while(pq.size() > 0){
                Pair p = pq.peek();
                if(map.get(p.ele) == p.freq){
                    res[i] = p.freq;
                    break;
                }
                else{
                    pq.poll();
                }
            }
        }

        return res;

    }
}