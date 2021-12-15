package leetcode.editor.cn;

//剑指 Offer II 003、前 n 个数字二进制中 1 的个数
class W3tCBm {
    public static void main(String[] args) {
        Solution solution = new W3tCBm().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                res[i] = res[i & (i - 1)] + 1;
            }
            return res;
        }

        //O(nlogn)
        public int[] countBits0(int n) {
            int[] res = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int j = i;
                while (j != 0) {
                    j = j & (j - 1);
                    res[i]++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}