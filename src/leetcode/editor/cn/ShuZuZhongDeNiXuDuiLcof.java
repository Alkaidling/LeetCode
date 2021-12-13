package leetcode.editor.cn;

//剑指 Offer 51、数组中的逆序对
class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        //归并排序
        public int mergeSort(int[] nums, int left, int right) {
            if (left >= right) {
                return 0;
            }
            int mid = left + (right - left) / 2;
            int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            int k = 0, i = left, j = mid + 1;
            int[] t = new int[right - left + 1];
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    t[k++] = nums[i++];
                } else { //nums[i] > nums[j]
                    res += (mid - i + 1);
                    t[k++] = nums[j++];
                }
            }
            while (i <= mid) {
                t[k++] = nums[i++];
            }
            while (j <= right) {
                t[k++] = nums[j++];
            }
            for (i = left, j = 0; i <= right; i++, j++) {
                nums[i] = t[j];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}