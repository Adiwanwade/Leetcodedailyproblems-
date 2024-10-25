class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        // Check for both conditions:
        // 1. Trees are equivalent without flips.
        // 2. Trees are equivalent with flips (left child of root1 with right child of root2 and vice versa).
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
