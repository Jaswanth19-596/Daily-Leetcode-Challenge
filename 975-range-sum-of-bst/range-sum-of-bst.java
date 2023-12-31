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

    // Bruteforce

    int getSum(TreeNode root, int low, int high){

        if(root == null)    return 0;

        if(root.val < low)  return getSum(root.right, low, high);
        if(root.val > high) return getSum(root.left, low, high);

        int leftSum = getSum(root.left, low, high);
        int rightSum = getSum(root.right, low, high);

        int rootValue = 0;

        if(root.val >= low && root.val <= high){
            rootValue = root.val;
        }

        return rootValue + leftSum + rightSum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return getSum(root, low, high);
    }
}