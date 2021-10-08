package leetcode.editor.cn;

//1736、替换隐藏数字得到的最晚时间
class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        String time = "??:3?";
        String s = solution.maximumTime(time);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumTime(String time) {
            char[] arr = time.toCharArray();
            if (arr[0] == '?') {
                arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
            }
            if (arr[1] == '?') {
                arr[1] = (arr[0] == '2') ? '3' : '9';
            }
            if (arr[3] == '?') {
                arr[3] = '5';
            }
            if (arr[4] == '?') {
                arr[4] = '9';
            }
            return new String(arr);
        }

        //拼接
        public String maximumTime1(String time) {
            StringBuilder builder = new StringBuilder();
            if (time.startsWith("?")) {
                if (time.charAt(1) != '?' && (time.charAt(1) - '0' >= 4)) {
                    builder.append(1);
                } else {
                    builder.append('2');
                }
            } else {
                builder.append(time.charAt(0));
            }
            for (int i = 1; i < time.length(); i++) {
                char ch = time.charAt(i - 1);
                if (time.charAt(i) == '?') {
                    if (i == 1 && (ch == '1' || ch == '0')) {
                        builder.append('9');
                    } else if (i == 1 && (ch == '2' || ch == '?')) {
                        builder.append('3');
                    } else if (i == 3) {
                        builder.append('5');
                    } else if (i == 4) {
                        builder.append('9');
                    }
                } else {
                    builder.append(time.charAt(i));
                }
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}