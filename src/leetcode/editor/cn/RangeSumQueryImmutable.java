package leetcode.editor.cn;

//303、区域和检索 - 数组不可变
class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray numArray = new RangeSumQueryImmutable().new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n+1];
            for (int i = 0; i < n; i++) {
                sums[i+1] = nums[i] + sums[i]; //前缀和
            }
        }

        public int sumRange(int left, int right) {
            return sums[right+1] - sums[left];
        }

        //public NumArray(int[] nums) {
        //    this.nums = nums;
        //}
        //
        //public int sumRange(int left, int right) {
        //    if (nums.length == 0) {
        //        return 0;
        //    }
        //    int sum = 0;
        //    for (int i = left; i <= right; i++) {
        //        sum += nums[i];
        //    }
        //    return sum;
        //}
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}