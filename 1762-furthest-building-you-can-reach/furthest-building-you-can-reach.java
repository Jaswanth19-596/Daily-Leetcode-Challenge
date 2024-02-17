class Solution {

     public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1;i<heights.length;i++){
            if(heights[i] - heights[i-1] > 0){
                // We are using a ladder
                pq.add(heights[i] - heights[i-1]);
            }

            if(pq.size() > ladders){
                int diff = pq.poll();
                if(bricks < diff)   return count;
                bricks -= diff;
            }
            count++;
        }

        return count;

    }
}