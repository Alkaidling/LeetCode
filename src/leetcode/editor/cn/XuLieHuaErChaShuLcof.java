package leetcode.editor.cn;

import java.util.ArrayDeque;

//剑指 Offer 37、序列化二叉树
class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode deserialize = solution.deserialize("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            builder.append(root.val);
            builder.append(",");
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        builder.append(node.left.val);
                    } else {
                        builder.append("null");
                    }
                    builder.append(",");
                    if (node.right != null) {
                        queue.offer(node.right);
                        builder.append(node.right.val);
                    } else {
                        builder.append("null");
                    }
                    builder.append(",");
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0) {
                return null;
            }
            String[] strings = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int index = 1;
            while (index < strings.length) {
                TreeNode node = queue.poll();
                String str1 = strings[index++];
                if (!str1.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(str1));
                    queue.offer(node.left);
                }
                String str2 = strings[index++];
                if (!str2.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(str2));
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}