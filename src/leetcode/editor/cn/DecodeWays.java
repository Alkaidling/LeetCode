package leetcode.editor.cn;

//91、解码方法
class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        int i = solution.numDecodings("1001");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numDecodings(String s) {
            int n = s.length();
            int[] f = new int[n + 1]; //f[n]为字符串n-1位置的结果
            f[0] = 1;
            for (int i = 1; i <= n; ++i) {
                //i-1位置不为0，结果就加上前一个位置的结果
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                }
                //i-2位置不为0，且i-1和i-2位置值小于27，当前位置结果就加上i-2位置的结果
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    f[i] += f[i - 2];
                }
                //如果i-1和i-2位置都为0，则f[i]和它之后的所有值均为0
            }
            return f[n];
        }

        public int numDecodings0(String s) {
            char[] chars = s.toCharArray();

            if (chars[0] == '0') {
                return 0;
            }
            int n = chars.length;
            if (n == 1) {
                return 1;
            }
            int first = 1;
            int val0 = chars[0] - '0';
            int val1 = chars[1] - '0';
            int second = 0;
            if (val1 != 0) {
                if (n > 2 && chars[2] == '0') {
                    if(val1 > 2){
                        return 0;
                    }else {
                        second = 1;
                    }
                }else {
                    second = val0*10 + val1 > 26 ? 1 : 2;
                }
            }else {
                if (val0 > 2) {
                    return 0;
                }else {
                    second = 1;
                }
            }
            for (int i = 2; i < n; i++) {
                int curVal = chars[i] - '0';
                int preVal = chars[i - 1] - '0';
                int cur;
                if (curVal == 0) {
                    if(preVal > 2 || preVal == 0){
                        return 0;
                    }else {
                       cur = first;
                    }
                }else{
                    if (preVal == 0) {
                        cur = second;
                    }else {
                        int value = preVal * 10 + curVal;
                        if (value > 26) {
                            cur = second;
                        } else {
                            cur = first + second;
                        }
                    }
                }
                first = second;
                second = cur;
            }
            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}