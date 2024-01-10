/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    void traverse(TreeNode root, HashMap<Integer, ArrayList<Integer>> adj){

        if(root == null || (root.left == null && root.right == null))    return;
        
        TreeNode parent = root;
        TreeNode child1 = root.left;
        TreeNode child2 = root.right;


        if(child1 != null){
            if(adj.containsKey(parent.val)){
                ArrayList<Integer> list = adj.get(parent.val);
                list.add(child1.val);
                adj.put(parent.val, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(child1.val);
                adj.put(parent.val, list);
            }

             if(adj.containsKey(child1.val)){
                ArrayList<Integer> list = adj.get(child1.val);
                list.add(parent.val);
                adj.put(child1.val, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(parent.val);
                adj.put(child1.val, list);
            }
        }

        if(child2 != null){
              if(adj.containsKey(parent.val)){
                ArrayList<Integer> list = adj.get(parent.val);
                list.add(child2.val);
                adj.put(parent.val, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(child2.val);
                adj.put(parent.val, list);
            }

             if(adj.containsKey(child2.val)){
                ArrayList<Integer> list = adj.get(child2.val);
                list.add(parent.val);
                adj.put(child2.val, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(parent.val);
                adj.put(child2.val, list);
            }
        }
        traverse(root.left, adj);
        traverse(root.right, adj);        
    }


    int dfs(int node, Set<Integer> set, HashMap<Integer, ArrayList<Integer>> adj){

        if(set.contains(node))   return 0;

        set.add(node);

        int max = 0;
        System.out.println(node);
        if (adj.containsKey(node) && adj.get(node) != null) {
    for (int child : adj.get(node)) {
        int res = dfs(child, set, adj);
        max = Math.max(res, max);
    }
}

        set.remove(node);
        return 1 + max;
    }



    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();


        traverse(root,adj);
        // System.out.println(adj);

        Set<Integer> set = new HashSet<>();

        return dfs(start, set, adj)-1;

    }
}