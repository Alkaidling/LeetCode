package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//506、相对名次
class RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
        String[] relativeRanks = solution.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
        System.out.println(Arrays.toString(relativeRanks));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:9 ms,击败了56.90% 的Java用户 内存消耗:39.7 MB,击败了22.76% 的Java用户
        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            String[] res = new String[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); //大顶堆
            for (int i = 0; i < n; i++) {
                map.put(score[i], i);
                heap.offer(score[i]);
            }
            String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
            int index = 0;
            while (!heap.isEmpty()) {
                index++;
                if (index < 4) {
                    res[map.get(heap.poll())] = desc[index-1];
                }else {
                    res[map.get(heap.poll())] = new StringBuilder().append(index).toString();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}