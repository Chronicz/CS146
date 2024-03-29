public class Solution {
    public boolean isValidBST(TreeNode root) {
        // set initial values for min and max bounds for comparison
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        // Base case
        if (root == null)
            return true;
        // if root value is less or equal to min
        // If root value is greater or equal to max
        // then is not valid BST
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        // Recursive call left and right tree
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
