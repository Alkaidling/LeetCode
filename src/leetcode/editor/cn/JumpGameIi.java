package leetcode.editor.cn;

//45、跳跃游戏 II
class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] nums = {2,3,1,1,4};
        int jump = solution.jump2(nums);
        System.out.println(jump);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //双指针 + 贪心 + 动态规划  O(n) O(n)
        //状态转移方程：f[i] = f[j] + 1
        public int jump3(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 1, j = 0; i < n; i++) {
                while (j + nums[j] < i) j++;
                f[i] = f[j] + 1;
            }
            return f[n - 1];
        }

        //（贪心）反向查找可到达的最大位置  O(n²)
        public int jump2(int[] nums) {
            int position = nums.length - 1;
            int steps = 0;
            while (position > 0) {
                for (int i = 0; i < position; i++) {
                    if (i + nums[i] >= position) {
                        position = i;
                        steps++;
                        break;
                    }
                }
            }
            return steps;
        }

        //（贪心）正向查找可到达的最大位置  O(n)
        public int jump1(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition,i+nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }


        //递归
        public int jump0(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            return process(nums, 0, nums[0]);
        }

        int min = Integer.MAX_VALUE;

        private int process(int[] nums, int index, int len) {
            if (index == nums.length - 1) {
                return 0;
            }
            if (index + len == nums[nums.length - 1] || len > nums.length) {
                return 1;
            }
            for (int i = index + 1; i <= len + index; i++) {
                if (i + index >= nums.length) {
                    break;
                }
                if (nums[i] == 0) {
                    continue;
                }
                int p = process(nums, i, nums[i]) + 1;
                min = Math.min(p, min);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}