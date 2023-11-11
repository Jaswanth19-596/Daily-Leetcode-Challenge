class Solution {


    void dfs(int curr, Set<Integer> visited, ArrayList<Integer> list, HashMap<Integer,ArrayList<Integer>> adj){

        if(visited.contains(curr))  return;

        visited.add(curr);

        list.add(curr);

        for(int child : adj.get(curr)){
            if(visited.contains(child) == false){
                dfs(child,visited,list,adj);
            }
        }

    }




    public int[] restoreArray(int[][] adjacentPairs) {
        
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

        // for(int i = 0;i<adjacentPairs.length;i++){
        //     adj.add(new ArrayList<>());
        //     adj.put()
        // }

        Set<Integer> set = new HashSet<>();

        for(int edge[] : adjacentPairs){

            if(adj.containsKey(edge[0]) == false){
                adj.put(edge[0], new ArrayList<>());
            }
            if(adj.containsKey(edge[1]) == false){
                adj.put(edge[1], new ArrayList<>());
            }

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);


            if(set.contains(edge[1])){
                set.remove(edge[1]);
            }
            else{
                set.add(edge[1]);
            }

            if(set.contains(edge[0])){
                set.remove(edge[0]);
            }
            else{
                set.add(edge[0]);
            }
        }

        int startPoint = 0;

        for(int ele : set){
            startPoint = ele;
            break;
        }

        System.out.println(set);

        ArrayList<Integer> list = new ArrayList<>();

        dfs(startPoint, new HashSet<Integer>(), list, adj);

        int n = adjacentPairs.length + 1;

        int res[] = new int[list.size()];

        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}