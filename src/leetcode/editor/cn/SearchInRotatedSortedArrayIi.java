package leetcode.editor.cn;

//81、搜索旋转排序数组 II
class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        int[] nums = {2, 2, 2, 1, 2};
        boolean search = solution.search(nums, 1);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //最坏情况元素均相等，且不等于target，此时时间复杂度为O(n)
        public boolean search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target == nums[mid]) {
                    return true;
                }
                if (nums[mid] > nums[end]) { //反转在mid到end范围里
                    if (target >= nums[start] && target < nums[mid]) {  //目标值在有序部分 start到end 则直接去有序部分找
                        end = mid - 1;
                        continue;
                    } else {  //目标在无序部分,则缩小无序的范围，继续循环
                        start = mid + 1;
                        continue;
                    }
                } else if (nums[mid] < nums[start]) { //反转在start到mid范围里
                    if (target <= nums[end] && target > nums[mid]) {  //目标值在序部分 mid到end 则直接去有序部分找
                        start = mid + 1;
                        continue;
                    } else {  //目标在无序部分,则缩小无序的范围，继续循环
                        end = mid - 1;
                        continue;
                    }
                }
                //若，头尾中间部分值都相等，则无法判断反转部分在哪，例如2,2,2,1,2  2,1,2,2,2
                //因为nums[start]和nums[end]都不等于target，所以可以直接缩小范围
                else if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                    start++;
                    end--;
                } else { //此时为正常数组
                    if (target > nums[mid]) {
                        start = mid + 1;
                        continue;
                    } else {
                        end = mid - 1;
                        continue;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}