package leetcode.editor.cn;

//33、搜索旋转排序数组
class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        //int[] nums = {4,5,6,7,1,2,3};
        //int[] nums = {5,6,7,1,2,3,4};
        int[] nums = {4,5,6,7,8,1,2,3};
        int search = solution.search(nums, 8);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //二分查找 O(logn)
        //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环。
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if(target == nums[mid]){
                    return mid;
                }
                if(nums[mid] > nums[end]) { //反转在mid到end范围里
                    if(target >= nums[start] && target < nums[mid]){  //目标值在有序部分
                        end = mid - 1;
                        continue;
                    }else {
                        start = mid + 1;
                        continue;
                    }
                }else if (nums[mid] < nums[start]) { //反转在start到mid范围里
                    if(target <= nums[end] && target > nums[mid]) {  //目标值在序部分
                        start = mid + 1;
                        continue;
                    }else {
                        end = mid - 1;
                        continue;
                    }
                }else { //此时为正常数组
                    if(target > nums[mid]){
                        start = mid + 1;
                        continue;
                    }else {
                        end = mid - 1;
                        continue;
                    }
                }

            }
            return -1;
        }


        //遍历查找 O(n)
        public int search1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}