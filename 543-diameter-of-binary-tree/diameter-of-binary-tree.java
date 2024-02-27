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

    int height(TreeNode root){

        if(root == null)    return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }


    int findDiameter(TreeNode root){

        if(root == null)    return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diamterOfCurrentNode = leftHeight + rightHeight;
        int diamterOfLeftTree = findDiameter(root.left);
        int diamterOfRightTree = findDiameter(root.right);

        return Math.max(diamterOfCurrentNode, Math.max(diamterOfLeftTree, diamterOfRightTree));
    }


    public int diameterOfBinaryTree(TreeNode root) {
        return findDiameter(root);
    }
}