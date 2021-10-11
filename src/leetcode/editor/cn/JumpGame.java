package leetcode.editor.cn;

//55、跳跃游戏
class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] nums = {2,3,1,1,4};
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp还不如贪心
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];  //dp[i]为i跳到的最远位置
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] < i) {
                    return false;
                }
                dp[i] = Math.max(dp[i-1],i+nums[i]);
                if (dp[i] >= n - 1) {
                    return true;
                }
            }
            return true;
        }

        //执行耗时:3 ms,击败了43.49% 的Java用户 内存消耗:39.9 MB,击败了27.63% 的Java用户
        public boolean canJump1(int[] nums) {
            int rightmost = 0; //rightmost为最远到达的地方
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (rightmost < i) {
                    return false;  //到不了i位置则一定到不了最后
                }
                rightmost = Math.max(rightmost, i + nums[i]); //到了i位置，看从i位置是否可以跳的更远
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}