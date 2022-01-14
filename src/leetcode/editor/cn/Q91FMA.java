package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 093、最长斐波那契数列
class Q91FMA {
    public static void main(String[] args) {
        Solution solution = new Q91FMA().new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int n = arr.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(arr[i],i);
            }
            Map<Integer, Integer> longest = new HashMap<>();
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int k = map.getOrDefault(arr[i] - arr[j], - 1);
                    if (k >= 0 && k < j) {
                        int cand = longest.getOrDefault(k * n + j,2) + 1;
                        longest.put(j * n + i,cand);
                        res = Math.max(res,cand);
                    }
                }
            }
            return res > 2 ? res : 0;
        }

        public int lenLongestFibSubseq1(int[] arr) {
            int n = arr.length;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(arr[i]);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int x = arr[j], y = arr[i] + arr[j];
                    int len = 2;
                    while (set.contains(y)) {
                        int t = y;
                        y += x;
                        x = t;
                        res = Math.max(++len,res);
                    }
                }
            }
            return res > 2 ? res : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}