package leetcode.editor.cn;

import java.util.Random;

//215、数组中的第K个最大元素
class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int kthLargest = solution.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums,0,nums.length-1,k-1);
        }
        //快速选择(快排模板)
        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left >= right) {
                return nums[left];
            }
            //每次随机取样
            int randomIndex = random.nextInt(right - left + 1) + left;
            swap(nums,left,randomIndex);
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
            if (k > j) { //此时数组中前j个数都大于(或等于)后面的数，如果k大于j，则在j后面部分继续寻找
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