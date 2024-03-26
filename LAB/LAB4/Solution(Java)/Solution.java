class Solution {
    public static TreeNode invertTree(TreeNode root) {
        // Since we need access to both left and right
        // tree before we swap due to single children
        // Therefore, Post Order Traversal will work well

        // base case
        if (root == null)
            return null;

        // Traverse left Tree
        invertTree(root.left);
        // Traverse Right Tree
        invertTree(root.right);

        // Swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void printTree(TreeNode root) {

        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }

    public static void main(String[] args) {
        // Test Cases

        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n8 = new TreeNode(8, n5, n6);
        TreeNode n1 = new TreeNode(1, n2, n8);

        System.out.println("Tree Before Invert");
        printTree(n1);
        invertTree(n1);
        System.out.println();
        System.out.println("Tree After Invert");
        printTree(n1);
    }
}