package leetcode.editor.cn;

import java.util.Arrays;

//Java：加一
class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = {9};
        int[] ints = solution.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
            //digits[i]++;
            //digits[i] = digits[i] % 10;
            //if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        if(digits[index] == 9 && index != 0){
            digits[index] = 0;
            digits[--index]++;
            while (digits[index] > 9){
                if(index == 0){
                    int len = digits.length + 1;//新数组长度
                    digits = new int[len];
                    digits[0] = 1;
                    return digits;
                }
                digits[index] = 0;
                digits[--index]++;
            }
        }else if(digits[index] == 9 && index == 0){
            int[] newdigits = {1,0};
            return newdigits;
        } else
            digits[index]++;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}