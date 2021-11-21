package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//559、N 叉树的最大深度
class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        //bfs
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            int res = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size > 0) {
                    Node node = queue.poll();
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                    size--;
                }
                res++;
            }
            return res;
        }

        //dfs
        public int maxDepth1(Node root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            for (Node child : root.children) {
                res = Math.max(maxDepth(child), res);
            }
            return res + 1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}