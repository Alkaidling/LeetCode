package leetcode.editor.cn;

import java.util.Arrays;

//31、下一个排列
class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        //int[] nums = {1,12,11};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:1 ms,击败了48.42% 的Java用户 内存消耗:38.5 MB,击败了73.67% 的Java用户
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            boolean flag = true;
            for (int i = n - 1; i >= 0; i--) { // i 尽可能靠右
                if (!flag) {
                    break;
                }
                int t = nums[i];
                int index = i;
                for (int j = i + 1; j < n; j++) {  //在 i 右边找到比 nums[i] 大，且值最小的位置index
                    if (nums[j] > nums[i]) {
                        if(t != nums[i]){
                            if (nums[j] < t) {
                                t = nums[j];
                                index = j;
                            }
                        }else {
                            t = nums[j];
                            index = j;
                        }
                    }
                }
                if (index > i) { //在i右边找到了index
                    swap(nums, i, index);   //交换 nums[i] 和 nums[index]
                    //将i右边升序排列
                    quicksort(nums, i + 1, n - 1);
                    flag = false;
                }
            }
            if (flag) {
                quicksort(nums, 0, n - 1);
            }
        }

        //快排
        private void quicksort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int x = nums[(left + right) / 2];
            int i = left - 1, j = right + 1;
            while (i < j) {
                do {
                    i++;
                } while (nums[i] < x);
                do {
                    j--;
                } while (nums[j] > x);
                if (i < j) {
                    swap(nums, i, j);
                }
            }
            quicksort(nums, left, j);
            quicksort(nums, j + 1, right);
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}