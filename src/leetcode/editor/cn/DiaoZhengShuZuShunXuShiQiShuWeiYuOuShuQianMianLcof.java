package leetcode.editor.cn;

import java.util.Arrays;

//剑指 Offer 21、调整数组顺序使奇数位于偶数前面
class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] exchange = solution.exchange(new int[]{1, 3, 5});
        System.out.println(Arrays.toString(exchange));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:2 ms,击败了79.01% 的Java用户 内存消耗:46.5 MB,击败了26.54% 的Java用户
        public int[] exchange(int[] nums) {
            int n = nums.length;
            int i = 0;
            int j = n - 1;
            while (i < j) {
                while (i < j && (nums[i] & 1) == 1) {
                    i++;
                }
                while (i < j && (nums[j] & 1) == 0) {
                    j--;
                }
                if (i < j) {
                    swap(nums,i,j);
                }
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}