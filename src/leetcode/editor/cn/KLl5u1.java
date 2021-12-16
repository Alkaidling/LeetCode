package leetcode.editor.cn;

//剑指 Offer II 006、排序数组中两个数字之和
class KLl5u1 {
    public static void main(String[] args) {
        Solution solution = new KLl5u1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] > target) {
                    j--;
                } else if (numbers[i] + numbers[j] < target) {
                    i++;
                } else {
                    break;
                }
            }
            return new int[]{i, j};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}