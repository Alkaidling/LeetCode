package leetcode.editor.cn;

import java.util.Arrays;

//1846、减小和重新排列数组后的最大元素
class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        Solution solution = new MaximumElementAfterDecreasingAndRearranging().new Solution();
        int[] arr = {5,4,3,2,1};
        int i = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int n = arr.length;
            if (n == 1) {
                return 1;
            }
            Arrays.sort(arr);
            arr[0] = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] > 1) {
                    arr[i] = arr[i - 1] + 1;
                }
            }
            return arr[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}