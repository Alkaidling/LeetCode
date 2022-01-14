package leetcode.editor.cn;

import java.util.*;

//373、查找和最小的K对数字
class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
            int m = nums1.length;
            int n = nums2.length;
            for (int i = 0; i < Math.min(m, k); i++) {
                heap.offer(new int[]{i,0});
            }
            while (k-- > 0 && !heap.isEmpty()) {
                int[] ints = heap.poll();
                lists.add(Arrays.asList(nums1[ints[0]],nums2[ints[1]]));
                if (ints[1] + 1 < n) {
                    heap.offer(new int[]{ints[0],ints[1] + 1});
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}