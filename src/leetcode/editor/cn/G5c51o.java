package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 060、出现频率最高的 k 个数字
class G5c51o {
    public static void main(String[] args) {
        Solution solution = new G5c51o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int key = entry.getKey();
                int val = entry.getValue();
                if (heap.size() == k && heap.peek()[1] < val) {
                    heap.poll();
                }
                heap.offer(new int[]{key,val});
            }
            int[] res = new int[k];
            for(int i = 0; i < k; i++) {
                res[i] = heap.poll()[0];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}