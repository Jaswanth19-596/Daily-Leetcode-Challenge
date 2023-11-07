class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = dist.length;

        for(int i = 0;i<n;i++){
            double value = Math.ceil((double)dist[i]/(double)speed[i]);
            pq.add((int)value);
        }

        int noOfMonsters = 0;
        while(pq.size()>0 && pq.poll() > noOfMonsters){
            noOfMonsters++;
        }

        return noOfMonsters;


    }
}