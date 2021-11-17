package leetcode.editor.cn;

//剑指 Offer 53 - I、在排序数组中查找数字 I
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        int[] nums = {5,7,7,7,7,7,8,8,10};
        int search = solution.search(nums, 7);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            int x; //左边界
            int y; //右边界
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {  //求左边界
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            x = left;
            if (nums[x] != target) {
                return 0;
            }
            left = 0;
            right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {  //求右边界
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
            y = right;
            return y - x  + 1;
        }

        public int search1(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            int x = right;  //左边界的左边坐标

            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                }else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            int y = left;  //右边界的右边坐标

            return y - x - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}