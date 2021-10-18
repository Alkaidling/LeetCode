package leetcode.editor.cn;

//376、摆动序列
class WiggleSubsequence {
    public static void main(String[] args) {
        Solution solution = new WiggleSubsequence().new Solution();
        //int[] nums = {1,7,4,9,2,5};
        //int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        //int[] nums = {1,2,3,4,5,6,7,8,9};
        //int[] nums = {1, 17, 5, 10, 11, 17, 17, 5, 10, 13, 15, 10, 5, 16, 5, 10, 13, 15, 10, 5, 16, 83, 15, 10, 5, 16, 8};
        int[] nums = {1, 1, 1, 1, 1};
        int i = solution.wiggleMaxLength1(nums);
        System.out.println(i);
        i = solution.wiggleMaxLength(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // dp、贪心

        //模拟
        public int wiggleMaxLength1(int[] nums) {
            int n = nums.length;
            int max = 2;  //nums所有元素不全相等的情况下最小长度为2
            int[] div = new int[n - 1];
            int t = 0;
            for (int i = 0; i < n - 1; i++) {
                div[i] = nums[i + 1] - nums[i];  //div数组存入后一个减前一个的差
                t = Math.max(t, div[i]);
            }
            if (t == 0) {  //如果nums中所有元素均相等
                return 1;
            }
            int cur = div[0];
            int pre = cur;
            for (int i = 1; i < n - 1; i++) {
                if (div[i] == 0) {  //两元素相等直接跳过
                    continue;
                }
                pre = cur;
                cur = div[i];
                if (cur * pre < 0) {  //如果div[i] * div[i-1] < 0 即nums中i+1，i，i-i形成摆动数组
                    max++;
                }
            }
            return max;
        }

        //贪心
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return 1;
            }
            int max = 2;  //nums所有元素不全相等的情况下最小长度为2
            int temp = 2;
            int cur = nums[1] - nums[0], pre;
            for (int i = 1; i < n - 1; i++) {
                if (nums[i + 1] - nums[i] == 0) {
                    temp++;
                    continue;
                }
                pre = cur;
                cur = nums[i + 1] - nums[i];
                if (cur * pre < 0) {
                    max++;
                }
            }
            return temp == n ? 1 : max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}