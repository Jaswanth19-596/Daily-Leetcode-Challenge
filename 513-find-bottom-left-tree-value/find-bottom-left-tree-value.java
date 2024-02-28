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

    static int level = 0;
    static int leftValue = 0;

    void traverse(TreeNode root, int currLevel){
        if(root == null)    return;

        if(currLevel >= level){
            level = currLevel;
            leftValue = root.val;
        }
        traverse(root.right, currLevel + 1);
        traverse(root.left, currLevel + 1);
    }


    public int findBottomLeftValue(TreeNode root) {
        level = 0;
        leftValue = root.val;

        traverse(root, 0);

        return leftValue;
    }
}