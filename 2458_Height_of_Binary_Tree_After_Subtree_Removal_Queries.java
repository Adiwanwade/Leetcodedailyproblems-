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

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<TreeNode, Integer> heightCache = new HashMap<>();

        
        dfs(root, 0, 0, resultMap, heightCache);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = resultMap.get(queries[i]);
        }
        return result;
    }

    
    int height(TreeNode node, Map<TreeNode, Integer> heightCache) {
        if (node == null) {
            return -1;
        }

        
        if (heightCache.containsKey(node)) {
            return heightCache.get(node);
        }

        int h =
            1 +
            Math.max(
                height(node.left, heightCache),
                height(node.right, heightCache)
            );
        heightCache.put(node, h);
        return h;
    }

    
    void dfs(
        TreeNode node,
        int depth,
        int maxVal,
        Map<Integer, Integer> resultMap,
        Map<TreeNode, Integer> heightCache
    ) {
        if (node == null) {
            return;
        }

        resultMap.put(node.val, maxVal);

        
        dfs(
            node.left,
            depth + 1,
            Math.max(maxVal, depth + 1 + height(node.right, heightCache)),
            resultMap,
            heightCache
        );
        dfs(
            node.right,
            depth + 1,
            Math.max(maxVal, depth + 1 + height(node.left, heightCache)),
            resultMap,
            heightCache
        );
    }
}
