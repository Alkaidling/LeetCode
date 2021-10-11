package leetcode.editor.cn;

//45、跳跃游戏 II
class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] nums = {2,3,1,1,4};
        int jump = solution.jump3(nums);
        System.out.println(jump);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //从后往前找O(n²)
        public int jump(int[] nums) {
            int ans = 0;  //跳的步数
            int n = nums.length-1; //末尾位置
            while (n > 0) {
                for (int i = 0; i < n; i++) {
                    if (nums[i] + i >= n) {  //找到第一个能挑到末尾的位置i
                        ans++;  //总步数+1
                        n = i;  //继续求跳到i的步数
                        break;
                    }
                }
            }
            return ans;
        }

        //双指针 + 贪心 + 动态规划  O(n) O(n)
        //每次都贪心的取离 i 点最远的点 j 来更新 f[i] 保证跳的步数最少
        public int jump3(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 1, j = 0; i < n; i++) {
                while (j + nums[j] < i) { //如果j位置到不了i位置则选j的后一个位置
                    j++;
                }
                f[i] = f[j] + 1;   //状态转移方程：f[i] = f[j] + 1 (若能从j位置跳到i)
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
        //每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到maxPosition位置的点）作为下次的起跳点 ！
        public int jump1(int[] nums) {
            int length = nums.length;
            int end = 0;  // 上次跳跃可达范围右边界（下次的最右起跳点）
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition,i+nums[i]);
                if (i == end) {         // 到达上次跳跃能到达的右边界了
                    end = maxPosition;  //目前能跳到的最远位置变成了下次起跳位置的右边界
                    steps++;            // 进入下一次跳跃
                }
            }
            return steps;
        }


        //递归❌
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