package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//740、删除并获得点数
class DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
        int[] nums = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 8, 9, 21, 23, 54, 54};
        //int[] nums = {1,2,3};
        solution.deleteAndEarn(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n+m) m为元素中最大值 O(m)
        public int deleteAndEarn(int[] nums) {
            int maxVal = 0;
            for (int val : nums) {
                maxVal = Math.max(maxVal, val);
            }
            int[] sum = new int[maxVal + 1];
            for (int val : nums) {
                sum[val] += val;  //数组转换为，下标为nums中的元素，sum中的元素为nums中相同元素的和
            }
            return rob(sum);
        }

        public int rob(int[] nums) {  //同198
            int size = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }

        //O(nlogn)  O(n)
        public int deleteAndEarn0(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            n = map.size();
            int[] nums2 = new int[n];
            int index = 0;
            for (Integer integer : map.keySet()) {
                nums2[index++] = integer;
            }
            Arrays.sort(nums2);  //O(nlogn)
            int[] dp = new int[n];
            dp[0] = map.get(nums2[0]) * nums2[0];
            for (int i = 1; i < n; i++) {
                if (nums2[i] - nums2[i - 1] == 1) {
                    int temp = 0;
                    if (i > 1) {
                        temp  = dp[i-2];
                    }
                    dp[i] = Math.max(dp[i-1],map.get(nums2[i]) * nums2[i] + temp);  //类似于198题 dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
                } else if (nums2[i] - nums2[i - 1] > 1) {
                    dp[i] = map.get(nums2[i]) * nums2[i] + dp[i-1];
                }
            }
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}