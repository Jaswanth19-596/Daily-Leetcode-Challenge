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


    TreeNode getNode(int n, Map<Integer, TreeNode> map){

        if(map.containsKey(n)){
            return map.get(n);
        }
        TreeNode node = new TreeNode(n);
        map.put(n, node);
        return node;
    }



    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> map = new HashMap<>();


        for(int des[] : descriptions){

            int parent = des[0];
            int child = des[1];
            boolean isLeft = des[2] == 1;

            TreeNode parentNode = getNode(parent, map);
            TreeNode childNode = getNode(child, map);

            if(isLeft){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
        }

        for(int des[] : descriptions){            
            map.remove(des[1]);
        }

        for(Map.Entry<Integer, TreeNode> e : map.entrySet()){
            return e.getValue();
        }

        return null;

    }
}