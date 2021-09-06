package leetcode.editor.cn;
//Java：704、二分查找
class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        //int[] nums = {-1,0,3,5,9,12};
        int[] nums = {0,1};
        int search = solution.search(nums, 0);
        System.out.println(search);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > nums[mid])
                start = mid + 1;
            else if(target < nums[mid])
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}