package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 109、开密码锁
class ZlDJc7 {
    public static void main(String[] args) {
        Solution solution = new ZlDJc7().new Solution();
        System.out.println(solution.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            if ("0000".equals(target)) {
                return 0;
            }
            Set<String> dead = new HashSet<>();
            for (String deadend : deadends) {
                dead.add(deadend);
            }
            if (dead.contains("0000")) {
                return -1;
            }
            int res = 0;
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.offer("0000");
            HashSet<String> visit = new HashSet<>();
            while (!queue.isEmpty()) {
                res++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String status = queue.poll();
                    List<String> list = get(status);
                    for (String nextStatus : list) {
                        if (!visit.contains(nextStatus) && !dead.contains(nextStatus)) {
                            if (nextStatus.equals(target)) {
                                return res;
                            }
                            queue.offer(nextStatus);
                            visit.add(nextStatus);
                        }
                    }
                }
            }
            return -1;
        }

        // 枚举 status 通过一次旋转得到的数字
        public List<String> get(String status) {
            List<String> ret = new ArrayList<>();
            char[] array = status.toCharArray();
            for (int i = 0; i < 4; ++i) {
                char num = array[i];
                array[i] = num == '0' ? '9' : (char) (num - 1);
                ret.add(new String(array));
                array[i] = num == '9' ? '0' : (char) (num + 1);
                ret.add(new String(array));
                array[i] = num;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}