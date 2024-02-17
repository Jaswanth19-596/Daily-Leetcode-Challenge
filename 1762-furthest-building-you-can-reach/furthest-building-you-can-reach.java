class Solution {

    int solve(int i, int bricks, int ladders, int heights[], HashMap<String, Integer> map){

        if(bricks < 0 || ladders < 0)   return 0;

        if(i == heights.length - 1) return 1;
        String key = i + " "+bricks + " "+ladders;
        if(map.containsKey(key))    return map.get(key);

        if(heights[i+1] < heights[i])   return 1+solve(i+1, bricks, ladders, heights,map);

        int tookBricks = solve(i+1, bricks - (heights[i+1] - heights[i]), ladders, heights, map);

        int tookLadder = solve(i+1, bricks, ladders - 1, heights, map);

        int res =  1 + Math.max(tookBricks, tookLadder);

        map.put(key, res);

        return res;

    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int count = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1;i<heights.length;i++){
            if(heights[i] - heights[i-1] > 0){
                pq.add(heights[i] - heights[i-1]);
            }

            if(pq.size() > ladders){
                int diff = pq.poll();
                if(bricks < diff)   return count-1;
                bricks -= diff;
            }
            count++;
        }

        return count-1;

    }
}