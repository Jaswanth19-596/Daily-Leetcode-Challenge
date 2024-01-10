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


    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode target = null;

    void getNode(TreeNode root, int key){
        if(root == null)    return;
        if(root.val == key) this.target = root;
        
        parent.put(root.left, root);
        parent.put(root.right, root);
            
        getNode(root.right, key);
        getNode(root.left, key);
    }


    int getMaxDistance(TreeNode root, Set<TreeNode> set){

        if(root == null)    return 0;
        // if(root.left == null && root.right == null) return 1;
        if(set.contains(root))  return 0;

        set.add(root);
        
        int left =  getMaxDistance(root.left, set);
        int right = getMaxDistance(root.right, set);
        int parentNode = getMaxDistance(parent.get(root), set);
        
        int max = Math.max(left, right);

        return 1+Math.max(max, parentNode);

    }


    public int amountOfTime(TreeNode root, int start) {

        getNode(root, start);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
       int dist1 = getMaxDistance(target.left, set);
       int dist2 = getMaxDistance(target.right, set);
       int dist3 = getMaxDistance(parent.get(target), set);
        // System.out.println(dist3);
        // return dist3;
       return Math.max(Math.max(dist1, dist2), dist3);
    }
}