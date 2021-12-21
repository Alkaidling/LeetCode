package leetcode.editor.cn;

import java.time.LocalDate;
import java.util.*;

//1154、一年中的第几天
class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
        int a = solution.dayOfYear("2008-10-10");
        System.out.println(a);
        int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sums = new int[13];
        for (int i = 1; i < 13; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(sums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dayOfYear(String date) {
            String[] dates = date.split("-");
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);
            boolean flag = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);  //是否闰年
            int[] dayOfMonth = {0,31,59,90,120,151,181,212,243,273,304,334,365};
            int res = 0;
            res += dayOfMonth[month-1];
            res += day;
            if (flag && month > 2) {
                res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}