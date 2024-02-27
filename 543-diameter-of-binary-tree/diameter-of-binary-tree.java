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

    static int DIA = 0;
    
    int findDiameter(TreeNode root){

        if(root == null)    return 0;

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        DIA = Math.max(DIA, left + right);

        return 1 + Math.max(left, right);
       
    }


    public int diameterOfBinaryTree(TreeNode root) {
        // O(n)
        DIA = 0;
        findDiameter(root);
        return DIA;
    }
}