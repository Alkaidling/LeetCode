package leetcode.editor.cn;

//Java：704、二分查找
class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        int[] nums = {-1,0,3,5,9,12};
        //int[] nums = {0, 1};
        int search = solution.search(nums, 1);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target > nums[mid])
                    left = mid + 1;
                else if (target < nums[mid])
                    right = mid - 1;
                else if(target == nums[mid]){
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}