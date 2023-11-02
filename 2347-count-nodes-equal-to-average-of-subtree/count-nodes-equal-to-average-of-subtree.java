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

class Pair{

    int sum = 0, count = 0;

    Pair(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}



class Solution {

    int res = 0;

    public Pair dfs(TreeNode root){
        if(root == null)    return new Pair(0,0);

        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);

        int leftSum = leftPair.sum, leftCount = leftPair.count;
        int rightSum = rightPair.sum, rightCount = rightPair.count;

        int overallSum = leftSum + rightSum + root.val;
        int overallCount = 1 + leftCount + rightCount;

        int avg = overallSum / overallCount;

        if(avg == root.val){
            res += 1;
        }

        return new Pair(overallSum, overallCount);
    }


    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return res;
    }
}