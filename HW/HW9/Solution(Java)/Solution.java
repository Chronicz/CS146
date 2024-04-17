class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // your code here

        // base case
        if (root == null) {
            return root;
        }

        // Traverse left if root is larger
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Traverse right if root is smaller
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {

        // Announed Test Case
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);

        TreeNode n3 = new TreeNode(3, n1, null);
        TreeNode n8 = new TreeNode(8, n5, n9);
        TreeNode r4 = new TreeNode(4, n3, n8);

        TreeNode ans = lowestCommonAncestor(r4, n3, n1);
        System.out.println(ans.val);
    }
}
