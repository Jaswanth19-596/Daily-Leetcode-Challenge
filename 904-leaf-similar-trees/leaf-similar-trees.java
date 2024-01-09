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


    void traverse(TreeNode root, ArrayList<Integer> list){

        if(root == null)    return;

        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        traverse(root.left, list);
        traverse(root.right, list);
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1 = new ArrayList<>();
        ArrayList<Integer> tree2 = new ArrayList<>();

        traverse(root1, tree1);
        traverse(root2, tree2);

        if(tree1.size() != tree2.size())    return false;

        for(int i = 0;i<tree1.size();i++){
            if(tree1.get(i) != tree2.get(i))    return false;
        }
        return true;

    }
}