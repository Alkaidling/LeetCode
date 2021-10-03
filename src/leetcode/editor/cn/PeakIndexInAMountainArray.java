package leetcode.editor.cn;

//852、山脉数组的峰顶索引
class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
        int[] arr = {1, 2, 3, 5, 1};
        int index = solution.peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            int mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (arr[mid] > arr[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}