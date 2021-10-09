package leetcode.editor.cn;

//55、跳跃游戏
class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] nums = {3,2,1,0,4};
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:3 ms,击败了43.49% 的Java用户 内存消耗:39.9 MB,击败了27.63% 的Java用户
        public boolean canJump(int[] nums) {
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