package leetcode.editor.cn;

import java.util.Arrays;

//Java：1646、获取生成数组中的最大值
class GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        Solution solution = new GetMaximumInGeneratedArray().new Solution();
        int i = solution.getMaximumGenerated(4);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //全部存入数组并求最大值
    public int getMaximumGenerated(int n) {
        if(n == 1 || n == 2)
            return 1;
        if(n == 0)
            return 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 2;
        for (int i = 3; i <= n; i++) {
            if (i%2 == 0)
                nums[i] = nums[i / 2];
            else
                nums[i] = nums[i/2] + nums[i/2 + 1];
        }
        //System.out.println(Arrays.toString(nums));
        //Arrays.sort(nums);
        //return nums[n];
        return Arrays.stream(nums).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}