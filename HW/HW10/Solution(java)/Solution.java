import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Bfs Solution
        // The List of nodes of each level that we will add into from the queue
        // We traverse each level preorder to see how many node in each level
        // we add the nodes in each level into the queue then pop it into the result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        // Base case
        if (root == null)
            return result;

        // The root level only has root so add to queue
        q.add(root);

        // Pop queue which hold the nodes of each level into list
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                // peek and traverse if not null
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                // Pop the values in queue into a list
                // forms a list of nodes in the current level
                levelList.add(q.remove().val);
            }
            // Add the sublevel lists into our result list
            // sublevel list is defined locally every loop
            result.add(levelList);
        }
        // Done and return final result
        return result;
    }
}
