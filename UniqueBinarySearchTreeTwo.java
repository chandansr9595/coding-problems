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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return findBsts(1, n);
    }
    
    private List<TreeNode> findBsts(int low, int high){
        List<TreeNode> bsts = new ArrayList<>();
        
        if(low > high){
            bsts.add(null);
            return bsts;
        }
        
        for(int i=low; i<= high; i++){
            List<TreeNode> lBst = findBsts(low, i-1);
            List<TreeNode> rBst = findBsts(i+1, high);
            for(TreeNode ltr : lBst){
                for(TreeNode rtr: rBst){
                    TreeNode root = new TreeNode(i);
                    root.left = ltr;
                    root.right = rtr;
                    bsts.add(root);
                }
            }
        }
        return bsts;
    }
}