package leetcode.editor.cn;
//Java：搜索插入位置
class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = {1,3,5,6};
        //int[] nums = {1};
        //int[] nums = {};
        int target = 7;
        int i = solution.searchInsert(nums, target);
        System.out.println(i);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if (len == 0)
            return 0;
        if (target > nums[len - 1])
            return len;
        else if(target <= nums[0])
            return 0;

        int start = 0;
        int end =len - 1;
        int mid = 0;
        while (start != end) {
            mid = (start + end) / 2;
            if(start == mid)
                return start + 1;
            else if (end == mid)
                return end - 1;
            if (target > nums[mid])
                start = mid;
            else
                end = mid;
        }
        return 0;
    }


    public int searchInsert1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else return mid;
        }
        return nums[mid] < target ? mid+1 : mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}