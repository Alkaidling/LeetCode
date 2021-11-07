package leetcode.editor.cn;

//598、范围求和 II
class RangeAdditionIi {
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi().new Solution();
        int[][] ops = {};
        int i = solution.maxCount(3, 3, ops);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxCount(int m, int n, int[][] ops) {
            for (int[] op : ops) {
                m = Math.min(m, op[0]);
                n = Math.min(n, op[1]);
            }
            return m * n;
        }

        //O(m*n) MLE
        public int maxCount1(int m, int n, int[][] ops) {
            int[][] nums = new int[m][n];
            int max = 0;
            int res = 0;
            for (int i = 0; i < ops.length; i++) {
                int x = ops[i][0], y = ops[i][1];
                for (int j = 0; j < x; j++) {
                    for (int k = 0; k < y; k++) {
                        nums[j][k]++;
                        max = Math.max(max, nums[j][k]);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (max == nums[i][j]) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}