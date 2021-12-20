package leetcode.editor.cn;

import java.util.*;

//475、供暖器
class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
        int[] n = {1, 2, 3};
        int[] a = {1, 2, 3};
        System.out.println(solution.findRadius(n, a));
        System.out.println(solution.findRadius0(n, a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int res = 0;
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int i = 0;
            for (int house : houses) {
                //找到house右边的供暖器
                while (i < heaters.length && heaters[i] < house) {
                    i++;
                }
                if (i == 0) {  //所有的供暖期都比house靠右则直接选第一个
                    res = Math.max(res, heaters[i] - house);
                } else if (i == heaters.length) {  //没有比house更靠右的供暖器，则house最右边的房子只能选最右边的供暖器
                    return Math.max(res, houses[houses.length - 1] - heaters[heaters.length - 1]);
                } else {  //要么用房子前面的供暖器，要么用后面的，二者取近的
                    res = Math.max(res, Math.min(heaters[i] - house, house - heaters[i - 1]));
                }
            }
            return res;
        }

        public int findRadius1(int[] houses, int[] heaters) {
            int res = 0;
            Arrays.sort(heaters);
            for (int house : houses) {
                int left = 0, right = heaters.length - 1;
                int min = Integer.MAX_VALUE;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    if (heaters[mid] > house) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                min = Math.min(min, Math.abs(heaters[left] - house));
                if (left < heaters.length - 1) {
                    min = Math.min(min, Math.abs(heaters[left + 1] - house));
                }
                if (left > 0) {
                    min = Math.min(min, Math.abs(heaters[left - 1] - house));
                }
                res = Math.max(res, min);
            }
            return res;
        }


        public int findRadius0(int[] houses, int[] heaters) {
            int res = 0;
            for (int house : houses) {
                int min = Integer.MAX_VALUE;
                for (int heater : heaters) {
                    min = Math.min(min, Math.abs(heater - house));
                }
                res = Math.max(res, min);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}