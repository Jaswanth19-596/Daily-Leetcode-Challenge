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




    int checkPalindrome(Map<Integer, Integer> map, int n){

        if(n % 2 == 0){
            // traverse and if any number occurs 1 time return false
            int count = 0;
            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                if(e.getValue() == 1)   return 0;
                if(e.getValue() % 2 == 1)   count++;
            }
            return count < 2 ? 1 : 0;
        }
        else{
            int count = 0;
            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                if(e.getValue() % 2 == 1){
                    count++;
                }
            }
            return count < 2 ? 1 : 0;
        }
    }


    int traverse(TreeNode root, int n, Map<Integer, Integer> map){
        
        if(root == null)    return 0;

        if(root.left == null && root.right == null){
            map.put(root.val, map.getOrDefault(root.val, 0)+1);

            int res = checkPalindrome(map,n+1);
            if(res == 1){
                System.out.println(map+" "+(n+1));
            }
            if(map.get(root.val) == 1)  map.remove(root.val);
            else{
                map.put(root.val, map.get(root.val) - 1);
            }
            return res;
        }

        map.put(root.val, map.getOrDefault(root.val, 0)+1);

        int left = traverse(root.left, n+1, map);
        int right = traverse(root.right, n+1, map);

        if(map.get(root.val) == 1)  map.remove(root.val);
        else{
            map.put(root.val, map.get(root.val) - 1);
        }

        return left + right;
    }


    public int pseudoPalindromicPaths (TreeNode root) {
        return traverse(root,0, new HashMap<Integer, Integer>());
    }
}