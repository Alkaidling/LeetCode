package leetcode.editor.cn;

//剑指 Offer 58 - II、左旋转字符串
class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String abcdefg = solution.reverseLeftWords("abcdefg", 2);
        System.out.println(abcdefg);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:37.9 MB,击败了94.58% 的Java用户
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }

        //执行耗时:4 ms,击败了34.66% 的Java用户 内存消耗:38.5 MB,击败了8.15% 的Java用户
        public String reverseLeftWords1(String s, int n) {
            StringBuilder builder = new StringBuilder();
            for (int i = n; i < s.length(); i++) {
                builder.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                builder.append(s.charAt(i));
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}