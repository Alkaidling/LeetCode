package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 059、数据流的第 K 大数值
class JBjn9C {
    public static void main(String[] args) {
        KthLargest kthLargest = new JBjn9C().new KthLargest(3,new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        Queue<Integer> heap;
        int size;

        public KthLargest(int k, int[] nums) {
            heap = new PriorityQueue<>();
            size = k;
            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > size) {
                    heap.poll();
                }
            }
        }

        public int add(int val) {
            heap.offer(val);
            if (heap.size() > size) {
                heap.poll();
            }
            return heap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}