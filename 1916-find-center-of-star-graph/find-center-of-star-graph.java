class Solution {
    public int findCenter(int[][] edges) {
        
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int i = 1;i<=edges.length + 1;i++){
            adj.put(i, new ArrayList<>());
        }


        for(int [] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            adj.get(node1).add(node2);
            adj.get(node2).add(node1);

            if(adj.get(node1).size() == edges.length){
                return node1;
            }
            if(adj.get(node2).size() == edges.length){
                return node2;
            }
        }

        return -1;


    }
}