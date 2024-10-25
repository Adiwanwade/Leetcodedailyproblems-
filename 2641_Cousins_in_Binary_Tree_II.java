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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0; 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            int nextLevelSum = 0;
            
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr);
                
                
                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    queue.offer(curr.right);
                }
            }
            
           
            for (TreeNode node : level) {
                int childrenSum = 0;
                if (node.left != null) childrenSum += node.left.val;
                if (node.right != null) childrenSum += node.right.val;
                
                
                if (node.left != null) {
                    node.left.val = nextLevelSum - childrenSum;
                }
                if (node.right != null) {
                    node.right.val = nextLevelSum - childrenSum;
                }
            }
        }
        
        return root;
    }
}
