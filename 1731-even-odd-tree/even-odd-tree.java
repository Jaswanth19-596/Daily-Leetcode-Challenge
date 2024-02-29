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

    boolean checkEven(ArrayList<Integer> list){
        if(list.get(0) % 2 != 1)    return false;

        for(int i = 1;i<list.size();i++){
            if(list.get(i) % 2 != 1)    return false;

            if(list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }

    boolean checkOdd(ArrayList<Integer> list){
        if(list.get(0) % 2 != 0)    return false;

        for(int i = 1;i<list.size();i++){
            if(list.get(i) % 2 != 0)    return false;
            if(list.get(i) >= list.get(i-1))    return false;
        }
        return true;
    }



    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);


        while(q.size() > 0){
            boolean val = true;
            if(level % 2 == 0){
                val &= checkEven(list);
            }
            else{
                val &= checkOdd(list);
            }
            level = level + 1;

            if(val == false)    return false;

            list.clear();

            int n = q.size();

            for(int i = 0;i<n;i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                    list.add(curr.left.val);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    list.add(curr.right.val);
                }
            }
        }
        return true;

    }
}