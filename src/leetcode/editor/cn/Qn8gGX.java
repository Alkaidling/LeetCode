package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 061、和最小的 k 个数对
class Qn8gGX {
    public static void main(String[] args) {
        Solution solution = new Qn8gGX().new Solution();
        List<List<Integer>> lists = solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
            HashSet<String> set = new HashSet<>();
            heap.offer(new int[]{0,0});
            ArrayList<List<Integer>> lists = new ArrayList<>();
            while (k-- > 0 && !heap.isEmpty()) {
                int[] ints = heap.poll();
                lists.add(Arrays.asList(nums1[ints[0]],nums2[ints[1]]));
                if (ints[0] + 1 < nums1.length) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(ints[0] + 1);
                    builder.append("_");
                    builder.append(ints[1]);
                    if (set.add(builder.toString())) {
                        heap.offer(new int[]{ints[0] + 1,ints[1]});
                    }
                }
                if (ints[1] + 1 < nums2.length) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(ints[0]);
                    builder.append("_");
                    builder.append(ints[1] + 1);
                    if (set.add(builder.toString())) {
                        heap.offer(new int[]{ints[0],ints[1] + 1});
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}