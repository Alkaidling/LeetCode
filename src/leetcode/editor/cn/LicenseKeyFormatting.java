package leetcode.editor.cn;

//482、密钥格式化
class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new LicenseKeyFormatting().new Solution();
        String s = "5F323Z-23uie-9-wdgdfgdfgcvb";
        //String s = "---";
        String s1 = solution.licenseKeyFormatting(s, 2);
        System.out.println(s1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:10 ms,击败了80.07% 的Java用户 内存消耗:38.4 MB,击败了82.53% 的Java用户
        public String licenseKeyFormatting(String s, int k) {
            StringBuilder ans = new StringBuilder();
            int cnt = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '-') {
                    cnt++;
                    ans.append(Character.toUpperCase(s.charAt(i)));  //从后往前插入字符
                    if (cnt % k == 0) {  //k个字符插入'-'
                        ans.append("-");
                    }
                }
            }
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') { //删去末尾的'-'
                ans.deleteCharAt(ans.length() - 1);
            }

            return ans.reverse().toString();
        }


        //执行耗时:55 ms,击败了13.48% 的Java用户 内存消耗:39 MB,击败了24.97% 的Java用户
        public String licenseKeyFormatting1(String s, int k) {
            s = s.replaceAll("-", "");  //去掉所有的'-'
            int n = s.length();
            StringBuilder builder = new StringBuilder();
            builder.append(s);
            if (builder.length() == 0) {
                return builder.toString();
            }
            int preLen = n / k;  //总共需要分成preLen段
            int carry = k;  //第一段的长度
            if (n % k != 0) {
                carry = n % k;
            }
            builder.insert(carry, '-');
            for (int i = 1; i < preLen; i++) {
                builder.insert(carry + k * i + i, '-');
            }
            n = builder.length() - 1;
            if(builder.charAt(n) == '-'){  //删去末尾的'-'
                builder.deleteCharAt(n);
            }
            return builder.toString().toUpperCase();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}