package leetcode.editor.cn;

import java.util.*;

//75、颜色分类
class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] n = {0,1,0};
        solution.sortColors(n);
        System.out.println(Arrays.toString(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1;
            for (int i = 0; i <= right; i++) {
                while (i < right && nums[i] == 2) {
                    swap(nums,i,right--);
                }
                if (nums[i] == 0) {
                    swap(nums,left++,i);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}