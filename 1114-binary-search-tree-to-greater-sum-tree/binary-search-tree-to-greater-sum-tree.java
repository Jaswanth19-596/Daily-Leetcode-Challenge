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


    ArrayList<Integer> list = new ArrayList<>();
    int i = 0;

    void getArray(TreeNode root){

        if(root == null)    return;

        getArray(root.left);
        list.add(root.val);
        getArray(root.right);
    }


    void setTree(TreeNode root){

        if(root == null) return;

        setTree(root.left);
        root.val = list.get(i++);
        setTree(root.right);
    }



    public TreeNode bstToGst(TreeNode root) {
        getArray(root);

        int n = list.size();

        for(int i = n-2;i>=0;i--){
            list.set(i, list.get(i) + list.get(i+1));
        }

        setTree(root);
        return root;
    }
}