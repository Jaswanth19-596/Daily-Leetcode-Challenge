class Solution {

    int n,m;


    class Triplet implements Comparable<Triplet>{
        int weight,i,j;

        Triplet(int weight,int i,int j){
            this.weight = weight;
            this.i = i;
            this.j = j;
        }


        public int compareTo(Triplet t){
            if(this.weight < t.weight)  return -1;
            return 1;
        }

        public String toString(){
            return this.weight+" "+this.i+" "+this.j;
        }
    }



    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        int directions[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};


        int dist[][] = new int[n][m];

        for(int arr[] : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(0,0,0));

        while(pq.size() > 0){
            


            Triplet t = pq.poll();

            int hop = t.weight;
            int i = t.i;
            int j = t.j;

            if(dist[i][j] > hop){
                dist[i][j] = hop;
            }

            for(int direc[] : directions){

                int row = i + direc[0];
                int col = j + direc[1];

                if(row < 0 || col < 0 || row == n || col == m){
                    continue;
                }

                int newHop = Math.max(Math.abs(heights[row][col] - heights[i][j]),hop);

                if(dist[row][col] > newHop){
                    pq.add(new Triplet(newHop,row,col));
                }
            }
        }

        return dist[n-1][m-1];


    }
}