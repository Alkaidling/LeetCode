package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 035、最小时间差
class Five69nqc {
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
        int minDifference = solution.findMinDifference(Arrays.asList("00:00","04:00","22:00"));
        System.out.println(minDifference);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            if (timePoints.size() > 1440) {
                return 0;
            }
            boolean[] flag = new boolean[1440];
            for (String s : timePoints) {
                int hour = Integer.parseInt(s.substring(0,2));
                int minute = Integer.parseInt(s.substring(3,5));
                int total = hour * 60 + minute;
                if(flag[total]){
                    return 0;
                }
                flag[total] = true;
            }
            int pre = -1;
            int res = Integer.MAX_VALUE;
            int first = 1441;
            int last = -1;
            for (int i = 0; i < 1440; i++) {
                if(flag[i]){
                    if (pre >= 0) {
                        res = Math.min(res,i - pre);
                    }
                    pre = i;
                    first = Math.min(i,first);
                    last = Math.max(i,last);
                }
            }
            res = Math.min(res,1440 + first - last);
            return res;
        }

        public int findMinDifference0(List<String> timePoints) {
            if (timePoints.size() > 1440) {
                return 0;
            }
            Collections.sort(timePoints);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < timePoints.size(); i++) {
                String cur, pre;
                if (i == 0) {
                    cur = timePoints.get(timePoints.size() - 1);
                    pre = timePoints.get(0);
                }else {
                    cur = timePoints.get(i);
                    pre = timePoints.get(i - 1);
                }
                if (cur.equals(pre)) {
                    return 0;
                }
                int dif = 0;
                int curHour = Integer.parseInt(cur.substring(0,2));
                int curMin = Integer.parseInt(cur.substring(3,5));
                int preHour = Integer.parseInt(pre.substring(0,2));
                int preMin = Integer.parseInt(pre.substring(3,5));
                if (curHour == preHour) {
                    dif = curMin - preMin;
                }else {
                    if (preHour == 0 && curHour == 23) {
                        dif = 60 - curMin;
                    }else {//03:23  04:32
                        dif = (curHour - preHour - 1) * 60 + 60 - preMin + curMin;
                    }
                }
                dif = Math.min(dif,1440 - dif);
                min = Math.min(min,dif);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}