package leetcode.editor.cn;

import java.util.Random;

//215、数组中的第K个最大元素
class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums,0,nums.length-1,k-1);
        }
        //快速选择(快排)
        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left >= right) {
                return nums[left];
            }
            //每次随机取样
            int random = new Random().nextInt(right - left + 1) + left;
            swap(nums,left,random);
            int x = nums[left];
            int i = left - 1;
            int j = right + 1;
            while (i < j) {
                do {
                    i++;
                }while (nums[i] > x);
                do {
                    j--;
                }while (nums[j] < x);
                if (i < j) {
                    swap(nums,i,j);
                }
            }
            if (k > j) {
                return quickSelect(nums,j+1,right,k);
            }else {
                return quickSelect(nums,left,j,k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}