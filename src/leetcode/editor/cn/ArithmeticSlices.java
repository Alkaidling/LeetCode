package leetcode.editor.cn;

//413、等差数列划分
class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();
        int[] nums = {1, 2, 3, 4,5,6,7,8,9};
        int i = solution.numberOfArithmeticSlices(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // O(n)
        public int numberOfArithmeticSlices1(int[] nums) {
            return 0;
        }

        //o(n²)
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return 0;
            }
            int res = 0;
            boolean pre = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (j - i >= 3) {   //子数组长度大于3时，前面为true且，最后三个数两两差值相同则为true
                        pre = pre && (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]);
                        if (pre) {
                            res++;
                        }
                    } else if (j - i == 2) {  //子数组长度为3时，两两差值相同则为true
                        pre = nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2];
                        if (pre) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}