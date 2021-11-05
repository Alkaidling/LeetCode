package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//1218、最长定差子序列
class LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int i = solution.longestSubsequence(arr, -2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:4 ms,击败了95.94% 的Java用户 内存消耗:47.3 MB,击败了94.92% 的Java用户
        public int longestSubsequence(int[] arr, int difference) {
            int dp[] = new int[40001];
            int max = 0;
            for (int x : arr) {
                dp[x + 20000] = dp[x - difference + 20000] + 1;
                max = Math.max(max, dp[x + 20000]);
            }
            return max;
        }

        //执行耗时:46 ms,击败了27.41% 的Java用户 内存消耗:48.4 MB,击败了80.71% 的Java用户
        public int longestSubsequence2(int[] arr, int difference) {
            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num - difference, 0) + 1);
                max = Math.max(max, map.get(num));
            }
            return max;
        }

        //执行耗时:47 ms,击败了24.37% 的Java用户 内存消耗:56.4 MB,击败了10.15% 的Java用户
        public int longestSubsequence1(int[] arr, int difference) {
            int n = arr.length;
            int max = 1;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[0], 1);
            for (int i = 1; i < n; i++) {
                int t = arr[i] - difference;
                int len = map.getOrDefault(t, 0) + 1;
                map.put(arr[i], len);
                max = Math.max(max, len);
            }
            return max;
        }

        //执行耗时:43 ms,击败了37.06% 的Java用户 内存消耗:55.1 MB,击败了55.84% 的Java用户
        public int longestSubsequence0(int[] arr, int difference) {
            int n = arr.length;
            int[] dp = new int[n];
            int max = 1;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[0], 0);
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                int t = arr[i] - difference;
                if (map.containsKey(t)) {
                    dp[i] = dp[map.get(t)] + 1;
                    max = Math.max(max, dp[i]);
                }
                map.put(arr[i], i);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}