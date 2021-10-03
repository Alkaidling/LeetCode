package leetcode.editor.cn;

//剑指 Offer 53 - I、在排序数组中查找数字 I
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        int[] nums = {};
        int search = solution.search(nums, 2);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            int x = right;  //左边界

            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            int y = left;  //右边界

            return y - x - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}