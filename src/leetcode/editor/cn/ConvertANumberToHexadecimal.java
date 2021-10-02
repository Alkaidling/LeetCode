package leetcode.editor.cn;
//405、数字转换为十六进制数
class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        String s = solution.toHex(-181956);
        System.out.println(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        long value = (long)(Integer.MAX_VALUE) * 2 + 2;  // 1 << 32
        long res;
        if (num < 0) {
            res = value + num;
        }else {
            res = num;
        }
        while (res != 0){
            long div = res % 16;
            res = res / 16;
            char digit = div < 10 ? (char) ('0' + div) : (char) ('a' + div - 10);  //替代switch-case
            builder.append(digit);
        }

        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}