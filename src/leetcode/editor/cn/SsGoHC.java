package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 074、合并区间
class SsGoHC {
    public static void main(String[] args) {
        Solution solution = new SsGoHC().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int left = intervals[0][0], right = intervals[0][1];
            ArrayList<int[]> list = new ArrayList<>();
            for (int[] ints : intervals) {
                if (ints[0] <= right) {
                    right = Math.max(right, ints[1]);
                } else {
                    list.add(new int[]{left, right});
                    left = ints[0];
                    right = ints[1];
                }
            }
            list.add(new int[]{left, right});
            return list.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}