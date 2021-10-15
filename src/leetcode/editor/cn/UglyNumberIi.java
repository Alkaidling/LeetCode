package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;

//264、丑数 II
class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        int i = solution.nthUglyNumber(20);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // dp
        public int nthUglyNumber(int n) {
            return 0;
        }

        //TODO
        // 小根堆 + 哈希表去重
        public int nthUglyNumber2(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            HashSet<Long> set = new HashSet<>();
            int[] factors = {2, 3, 5};
            queue.offer(1L);
            set.add(1L);
            int ugly = 0;
            for (int i = 0; i < n; i++) {
                long curr = queue.poll();
                ugly = (int) curr;
                for (int factor : factors) {
                    long next = factor * ugly;
                    if (set.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            return ugly;
        }

        //O(n²)			Time Limit Exceeded
        public int nthUglyNumber1(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            HashSet<Long> set = new HashSet<>();
            queue.offer(2L);
            queue.offer(3L);
            queue.offer(5L);
            if (n < 7) {
                return n;
            }
            long[] dp = new long[n + 1];
            for (long i = 0; i < 7; i++) {
                dp[(int) i] = i;
                set.add((long) i);
            }
            for (int i = 7; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    long num = dp[j] * 2;
                    if (!set.contains(num)) {
                        set.add(num);
                        queue.offer(num);
                    }
                    num = dp[j] * 3;
                    if (!set.contains(num)) {
                        set.add(num);
                        queue.offer(num);
                    }
                    num = dp[j] * 5;
                    if (!set.contains(num)) {
                        set.add(num);
                        queue.offer(num);
                    }
                }
                while (!queue.isEmpty() && queue.peek() <= dp[i - 1]) {
                    queue.poll();
                }
                dp[i] = queue.peek();
            }
            return (int) dp[n];
        }


        //暴力尝试			Time Limit Exceeded
        public int nthUglyNumber0(int n) {
            if (n < 7) {
                return n;
            }
            int preVal = 6;
            for (int i = 7; i <= n; i++) {
                int num = preVal + 1;
                while (true) {
                    int carry = num;
                    while (carry > 1) {
                        if (carry % 2 == 0) {
                            carry /= 2;
                        } else if (carry % 3 == 0) {
                            carry /= 3;
                        } else if (carry % 5 == 0) {
                            carry /= 5;
                        } else {
                            break;
                        }
                    }
                    if (carry == 1) {
                        preVal = num;
                        break;
                    } else {
                        num++;
                    }
                }
            }
            return preVal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}