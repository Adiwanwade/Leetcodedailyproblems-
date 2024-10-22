class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

           
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

           
            pq.add(levelSum);
            if (pq.size() > k) {
                pq.poll();  
            }
        }

        
        if (pq.size() < k) {
            return -1;
        }

        return pq.peek();  
    }
}
