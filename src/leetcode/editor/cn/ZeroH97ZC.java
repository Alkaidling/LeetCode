package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 075、数组相对排序
class ZeroH97ZC {
    public static void main(String[] args) {
        Solution solution = new ZeroH97ZC().new Solution();
        int[] ints = solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] cnt = new int[1001];
            for (int i : arr1) {
                cnt[i]++;
            }
            int index = 0;
            for (int x : arr2) {
                while (cnt[x]-- > 0){
                    arr1[index++] = x;
                }
            }
            for (int x = 0; x < 1001; x++) {
                while (cnt[x]-- > 0) {
                    arr1[index++] = x;
                }
            }
            return arr1;
        }


        public int[] relativeSortArray0(int[] arr1, int[] arr2) {
            int n = arr1.length;
            HashSet<Integer> set = new HashSet<>();
            int[] res = new int[n];
            int index = 0;
            for (int k : arr2) {
                set.add(k);
                for (int i : arr1) {
                    if (i == k) {
                        res[index++] = i;
                    }
                }
            }
            int len = 0;
            int[] t = new int[n - index];
            for (int i : arr1) {
                if (!set.contains(i)) {
                    t[len++] = i;
                }
            }
            Arrays.sort(t);
            for (int i = index, j = 0; i < n; i++, j++) {
                res[i] = t[j];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}