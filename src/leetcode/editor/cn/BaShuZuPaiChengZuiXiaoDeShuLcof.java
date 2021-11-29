package leetcode.editor.cn;

import java.util.PriorityQueue;

//剑指 Offer 45、把数组排成最小的数
class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:5 ms,击败了60.47% 的Java用户 内存消耗:38 MB,击败了37.06% 的Java用户
        public String minNumber(int[] nums) {
            StringBuilder builder = new StringBuilder();
            PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> (a + b).compareTo(b + a));
            for (int num : nums) {
                queue.offer(String.valueOf(num));
            }
            while (!queue.isEmpty()) {
                builder.append(queue.poll());
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}