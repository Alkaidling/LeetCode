package leetcode.editor.cn;

import java.util.*;

//71、简化路径
class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] strings = path.split("/");
            Deque<String> queue = new ArrayDeque<>();
            for (String string : strings) {
                if ("..".equals(string)) {
                    if (!queue.isEmpty()) {
                        queue.pollLast();
                    }
                } else if (string.length() > 0 && !string.equals(".")) {
                    queue.offer(string);
                }
            }
            StringBuilder sb = new StringBuilder();
            if (queue.isEmpty()) {
                sb.append("/");
            }else {
                while (!queue.isEmpty()) {
                    sb.append("/");
                    sb.append(queue.poll());
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}