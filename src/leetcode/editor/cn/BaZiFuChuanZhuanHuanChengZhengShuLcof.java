package leetcode.editor.cn;

//剑指 Offer 67、把字符串转换成整数
class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
        int i = solution.strToInt("42");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strToInt0(String str) {
            char[] c = str.trim().toCharArray();
            if (c.length == 0) {
                return 0;
            }
            int index = 1, sign = 1;
            if(c[0] == '-'){
                sign = -1;
            }else if(c[0] != '+'){
                index = 0;
            }
            int res = 0, b = Integer.MAX_VALUE / 10;
            for (int i = index; i < c.length; i++) {
                if(c[i] < '0' || c[i] > '9'){
                    break;
                }
                if(res > b || res == b && c[i] > '7'){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + (c[i] - '0');
            }
            return res * sign;
        }

        public int strToInt(String str) {
            str = str.trim();
            if (str.length() == 0) {
                return 0;
            }
            boolean sign = false;  //是否为负数
            if(str.charAt(0) < '0' || str.charAt(0) > '9'){
                if(str.charAt(0) == '-'){
                    sign = true;
                    str = str.substring(1);
                }else if(str.charAt(0) == '+'){
                    str = str.substring(1);
                }else {
                    return 0;
                }
            }
            long res = 0;
            for (char ch : str.toCharArray()) {
                if(ch < '0' || ch > '9'){
                    break;
                }
                long num = ch - '0';
                res = res * 10 + num;
                if(!sign && res > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if (sign && res - 1 > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int) (sign ? -res : res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}