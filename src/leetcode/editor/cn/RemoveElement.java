package leetcode.editor.cn;

//Java：27、移除元素
class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        //int[] nums = {3, 2, 2, 3};
        //int[] nums = {0,1,2,2,2};
        int[] nums = {0,4,4,0,4,4,4,0,2};

        int len = solution.removeElement(nums, 4);
        System.out.println(len);
        System.out.println();

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                if (nums[left] == val) {
                    nums[left] = nums[right - 1];
                    right--;
                } else {
                    left++;
                }
            }
            return left;
        }

        public int removeElement1(int[] nums, int val) {
            if (nums == null || nums.length == 0)
                return 0;
            //if (nums.length == 1) {
            //    if (nums[nums.length - 1] == val)
            //        return 0;
            //    else
            //        return nums.length;
            //} else if (nums.length == 0 || nums == null)
            //    return 0;
            //右指针 i 指向当前将要处理的元素，左指针 index 指向下一个将要赋值的位置。
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index++] = nums[i];
                }
            }
            return index;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}