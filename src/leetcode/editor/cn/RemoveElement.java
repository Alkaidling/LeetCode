package leetcode.editor.cn;
//Java：移除元素
class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        int[] nums = {3,2,2,3};
        //int[] nums = {0,1,2,2,3,0,4,2};
        //int[] nums = {2};

        int len = solution.removeElement(nums,3);
        System.out.println(len);
        System.out.println();

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 1) {
            if (nums[nums.length-1] == val)
                return 0;
            else
                return nums.length;
        }else if (nums.length == 0 || nums == null)
            return 0;
        //if (nums == null || nums.length == 0)
        //    return 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}