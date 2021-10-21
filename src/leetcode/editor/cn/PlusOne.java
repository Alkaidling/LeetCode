package leetcode.editor.cn;

import java.util.Arrays;

//Java：66、加一
class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = {9};
        int[] ints = solution.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            int[] newNums = new int[n + 1];
            newNums[0] = 1;
            return newNums;
        }

        public int[] plusOne0(int[] digits) {
            int index = digits.length - 1;

            if (digits[index] == 9 && index != 0) {
                digits[index] = 0;
                digits[--index]++;
                while (digits[index] > 9) {
                    if (index == 0) {
                        int len = digits.length + 1;//新数组长度
                        digits = new int[len];
                        digits[0] = 1;
                        return digits;
                    }
                    digits[index] = 0;
                    digits[--index]++;
                }
            } else if (digits[index] == 9 && index == 0) {
                int[] newdigits = {1, 0};
                return newdigits;
            } else
                digits[index]++;
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}