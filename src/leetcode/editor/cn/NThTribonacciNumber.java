package leetcode.editor.cn;

//1137、第 N 个泰波那契数
class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int prePrePre = 0;  //T0 = 0;
            int prePre = 1;     //T1 = 1;
            int pre = 1;        //T2 = 1;
            if (n < 2) {
                return n;
            } else if (n == 2) {
                return 1;
            }
            int ans = pre + prePre + prePrePre;
            for (int i = 3; i < n; i++) {
                prePrePre = prePre;
                prePre = pre;
                pre = ans;
                ans = pre + prePre + prePrePre;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}