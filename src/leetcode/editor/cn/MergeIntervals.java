package leetcode.editor.cn;

import java.util.*;

//56、合并区间
class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] n = {{1,2},{8,10},{15,18},{2,6},{3,4}};
        int[][] merge = solution.merge(n);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
            ArrayList<int[]> lists = new ArrayList<>();
            int right = intervals[0][1];
            int left = intervals[0][0];
            for (int i = 1; i < intervals.length; i++) {
                if(intervals[i][0] <= right){
                    right = Math.max(intervals[i][1],right);
                }else {
                    lists.add(new int[]{left,right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            lists.add(new int[]{left,right});
            return lists.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}