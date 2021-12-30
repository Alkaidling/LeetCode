package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 048、序列化与反序列化二叉树
class H54YBf {
    public static void main(String[] args) {
        Codec codec = new H54YBf().new Codec();
        TreeNode deserialize = codec.deserialize("1,2,3,null,null,4,5");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        builder.append(node.val);
                        queue.offer(node.left);
                        queue.offer(node.right);
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
            String[] s = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(s[0]));
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int index = 1;
            while (index < s.length) {
                TreeNode node = queue.poll();
                if (!s[index].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(s[index]));
                    queue.offer(node.left);
                }
                index++;
                if (!s[index].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(s[index]));
                    queue.offer(node.right);
                }
                index++;
            }
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int x) {
            val = x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}