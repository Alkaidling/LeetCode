package leetcode.editor.cn;

import java.util.Arrays;

//Java：删除有序数组中的重复项
class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {1,1,2};
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums = {1};
        //int[] nums = {1,2};


        int len = solution.removeDuplicates(nums);
        System.out.println(len);
        System.out.println();

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            int j = i+1;
            if(j<=nums.length-1){
                while (nums[i] >= nums[j]){
                    if (j<nums.length-1)
                        j++;
                    else
                        break;
                }
            }
            if(j<=nums.length-1)
                nums[i+1] = nums[j];
            if (nums[i] == nums[nums.length-1])
                break;
        }
        System.gc();
        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
