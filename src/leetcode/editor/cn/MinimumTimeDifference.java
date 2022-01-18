package leetcode.editor.cn;

import java.util.*;

//539、最小时间差
class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            if (timePoints.size() > 1440) {
                return 0;
            }
            Collections.sort(timePoints);
            int res = 1440;
            String pre = timePoints.get(0);
            for (int i = 0; i < timePoints.size(); i++) {
                String cur;
                if (i == 0) {
                    cur = timePoints.get(timePoints.size() - 1);
                } else {
                    cur = timePoints.get(i);
                }
                if (cur.equals(pre)) {
                    return 0;
                }
                int t = 0;
                t += Integer.parseInt(cur.substring(0, 2)) - Integer.parseInt(pre.substring(0, 2));
                t *= 60;
                t -= Integer.parseInt(pre.substring(3));
                t += Integer.parseInt(cur.substring(3));
                t = Math.min(t, 1440 - t);
                res = Math.min(res, t);
                pre = timePoints.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}