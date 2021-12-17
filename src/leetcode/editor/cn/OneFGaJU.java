package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 007、数组中和为 0 的三个数
class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
        int[] n = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(n);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}