package leetcode.editor.cn;

//剑指 Offer II 002、二进制加法
class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
        String s = solution.addBinary("11", "10");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addBinary(String a, String b) {
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            int l1 = a.length() - 1;
            int l2 = b.length() - 1;
            while (l1 >= 0 || l2 >= 0) {
                int a1 = l1 >= 0 ? a.charAt(l1--) - '0' : 0;
                int b1 = l2 >= 0 ? b.charAt(l2--) - '0' : 0;
                int sum = a1 + b1 + carry;
                if (sum > 1) {
                    carry = 1;
                    sum -= 2;
                }else {
                    carry = 0;
                }
                builder.append(sum);
            }
            if (carry == 1) {
                builder.append(1);
            }
            return builder.reverse().toString();
        }


        public String addBinary0(String a, String b) {
            char[] charA = new StringBuilder(a).reverse().toString().toCharArray();
            char[] charB = new StringBuilder(b).reverse().toString().toCharArray();
            int i = 0;
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            while (i < charA.length && i < charB.length) {
                int sum = charA[i] - '0' + charB[i] - '0' + carry;
                if (sum > 1) {
                    carry = 1;
                    sum -= 2;
                } else {
                    carry = 0;
                }
                builder.append(sum);
                i++;
            }
            while (i < charA.length) {
                int num = charA[i++] - '0' + carry;
                if (num > 1) {
                    num -= 2;
                    carry = 1;
                } else {
                    carry = 0;
                }
                builder.append(num);
            }
            while (i < charB.length) {
                int num = charB[i++] - '0' + carry;
                if (num > 1) {
                    num -= 2;
                    carry = 1;
                } else {
                    carry = 0;
                }
                builder.append(num);
            }
            if (carry == 1) {
                builder.append(1);
            }
            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}