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


    int ans = 0;


    void traverse(TreeNode root, int min, int max){
        if(root == null)    return;

        int res1 = Math.abs(root.val - max);
        int res2 = Math.abs(root.val - min);

        ans = Math.max(Math.max(res1, res2), ans);

        traverse(root.left, Math.min(min, root.val), Math.max(max, root.val));       
        traverse(root.right, Math.min(min, root.val), Math.max(max, root.val));       
    }


    public int maxAncestorDiff(TreeNode root) {
        if(root == null)    return 0;
        traverse(root, root.val, root.val);
        return this.ans;
    }
}