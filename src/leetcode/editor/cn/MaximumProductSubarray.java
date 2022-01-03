package leetcode.editor.cn;

//152、乘积最大子数组
class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        //int[] nums = {-2, -1, -2, 3, 2, -4, -1};
        int[] nums = {-1,-3,6,-4,7,-1,2,5,-8,0,-2,1,-3,4,6,-7,5,-1,2};
        //int[] nums = {-1,-3,6,-4,7,-1,2,5,-8};
        //int[] nums = {1,0,-1,2,3,-5,-2};
        int i = solution.maxProduct(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length, min = nums[0], max = nums[0], res = nums[0];
            for (int i = 1; i < n; i++) {
                int tMin = min, tMax = max;
                max = Math.max(Math.max(nums[i] * tMax, nums[i] * tMin), nums[i]);
                min = Math.min(Math.min(nums[i] * tMax, nums[i] * tMin), nums[i]);
                res = Math.max(res, max);
            }
            return res;
        }

        // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值min
        public int maxProduct0(int[] nums) {
            int n = nums.length;
            int[] max = new int[n + 1];
            int[] min = new int[n + 1];
            max[0] = 1;
            min[0] = 1;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max[i + 1] = Math.max(nums[i],Math.max(max[i] * nums[i],min[i] * nums[i]));
                min[i + 1] = Math.min(nums[i],Math.min(max[i] * nums[i],min[i] * nums[i]));
                res = Math.max(res,max[i + 1]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}