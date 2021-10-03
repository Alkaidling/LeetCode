package leetcode.editor.cn;

//1818、绝对差值和
class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
        int[] nums1 = {9,3,5,1,7,4};
        int[] nums2 = {9,3,5,1,7,4};
        int i = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static final int MOD = 1000000007;


        //×
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] div = new int[n];
            int max = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                div[i] = Math.abs(nums1[i] - nums2[i]);
                if (div[i] > max) {
                    max = div[i];
                }
                if (div[i] < min) {
                    min = div[i];
                }
                sum = (sum + div[i]) % MOD;
            }
            sum = (sum - max) % MOD;
            sum = (sum + min) % MOD;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}