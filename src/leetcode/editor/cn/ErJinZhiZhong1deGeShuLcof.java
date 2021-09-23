package leetcode.editor.cn;
//Java：剑指 Offer 15、二进制中1的个数
class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1; //n = n & (n - 1) 用作判断n是否为2的幂，若为2的幂则计算得n为0
            ret++;
        }
        return ret;
        //return Integer.bitCount(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}