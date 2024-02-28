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
    static int nodeValue = 0;

    void traverse(TreeNode root, int currLevel){
        if(root == null)    return;

        traverse(root.right, currLevel + 1);

        if(currLevel >= level){
            level = currLevel;
            nodeValue = root.val;
        }

        traverse(root.left, currLevel + 1);
    }


    public int findBottomLeftValue(TreeNode root) {
        level = 0;
        nodeValue = root.val;
        traverse(root, 0);
        return nodeValue;
    }
}