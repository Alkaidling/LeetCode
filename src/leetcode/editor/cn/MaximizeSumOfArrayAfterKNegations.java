package leetcode.editor.cn;

import java.util.Arrays;

//1005、K 次取反后最大化的数组和
class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (k > 0 && nums[i] < 0) {
                    nums[i] = -nums[i];
                    k--;
                }
                res += nums[i];
            }
            if (k > 0) {
                Arrays.sort(nums);
                if (k % 2 == 0) {
                    return res;
                }else {
                    return res - nums[0]*2;
                }
            }else {
                return res;
            }
        }

        //执行耗时:2 ms,击败了72.97% 的Java用户 内存消耗:37.9 MB,击败了38.68% 的Java用户
        public int largestSumAfterKNegations0(int[] nums, int k) {
            Arrays.sort(nums);
            int count = 0;
            int count0 = 0;
            int res = 0;
            int n = nums.length;
            for (int num : nums) {
                if (num < 0) {
                    count++;
                } else if (num == 0) {
                    count0++;
                }
            }
            if (count > 0) {
                if (count > k) {
                    for (int i = 0; i < n; i++) {
                        if (i < k) {
                            res += -nums[i];
                        }else {
                            res += nums[i];
                        }
                    }
                    return res;
                }else {
                    k -= count;
                    for (int i = 0; i < count; i++) {
                        nums[i] = -nums[i];
                    }
                    Arrays.sort(nums);
                }
            }
            if (count0 != 0 || k % 2 == 0) {
                for (int num : nums) {
                    res += num;
                }
                return res;
            }else {
                for (int i = 1; i < n; i++) {
                    res += nums[i];
                }
                res += -nums[0];
                return res;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}