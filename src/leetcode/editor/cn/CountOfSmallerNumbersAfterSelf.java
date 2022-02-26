package leetcode.editor.cn;

import java.util.*;

//315、计算右侧小于当前元素的个数
class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        System.out.println(solution.countSmaller(new int[]{2, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr;
        int[] index;

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new ArrayList<>();
            arr = new int[nums.length];
            index = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                index[i] = i;
            }
            mergeSort(nums, 0, nums.length - 1);
            for (int i : arr) {
                list.add(i);
            }
            return list;
        }

        public void mergeSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            int k = 0, i = left, j = mid + 1;
            int[] temp = new int[right - left + 1];
            while (i <= mid && j <= right) {
                if (nums[index[i]] <= nums[index[j]]) {
                    temp[k++] = index[j++];
                } else {
                    arr[index[i]] += right - j + 1;
                    temp[k++] = index[i++];
                }
            }
            while (i <= mid) {
                temp[k++] = index[i++];
            }
            while (j <= right) {
                temp[k++] = index[j++];
            }
            for (i = left, j = 0; i <= right; i++, j++) {
                index[i] = temp[j];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}