package leetcode.editor.cn;

import java.util.*;

//6、Z 字形变换
class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows < 2) {
                return s;
            }
            ArrayList<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                rows.add(new StringBuilder());
            }
            int i = 0, flag = -1;
            for (char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows - 1){
                    flag = -flag;
                }
                i += flag;
            }
            StringBuilder sb = new StringBuilder();
            for (StringBuilder row : rows) {
                sb.append(row);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}