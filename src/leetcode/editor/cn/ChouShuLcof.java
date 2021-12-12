package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;

//剑指 Offer 49、丑数
class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        int i = solution.nthUglyNumber(11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int c2 = 0, c3 = 0, c5 = 0;
            for (int i = 1; i < n; i++) {
                int num1 = dp[c2] * 2, num2 = dp[c3] * 3, num3 = dp[c5] * 5;
                dp[i] = Math.min(num1, Math.min(num2, num3));
                if (dp[i] == num1) {
                    c2++;
                }
                if (dp[i] == num2) {
                    c3++;
                }
                if (dp[i] == num3) {
                    c5++;
                }
            }
            return dp[n - 1];
        }

        //小顶堆+哈希表去重，返回堆里弹出的第n的元素
        public int nthUglyNumber1(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>(); //小顶堆
            HashSet<Long> set = new HashSet<>();
            queue.offer(1L);
            long poll = 1;
            while (n-- > 0) {
                poll = queue.poll();
                if(set.add(poll*2)){
                    queue.offer(poll*2);
                }
                if(set.add(poll*3)){
                    queue.offer(poll*3);
                }
                if(set.add(poll*5)){
                    queue.offer(poll*5);
                }
            }
            return (int) poll;
        }

        //dp O(n²)
        public int nthUglyNumber0(int n) {
            long[] dp = new long[n];
            dp[0] = 1;
            int[] fac = {2, 3, 5};
            for (int i = 1; i < n; i++) {
                long min = Long.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    for (int f : fac) {
                        if (dp[j] * f > dp[i - 1]) {
                            min = Math.min(dp[j] * f, min);
                        }
                    }
                }
                dp[i] = (int) min;
            }
            return (int) dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}