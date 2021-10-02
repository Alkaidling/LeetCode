package leetcode.editor.cn;

import java.util.Arrays;

//34、在排序数组中查找元素的第一个和最后一个位置
class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {1,2,3,3,3,3,4,5,9};
        int[] ints = solution.searchRange(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(log n)  二分查找先找其左边界，再找其右边界
        public int[] searchRange(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int x = -1;
            int y = -1;
            while (start <= end) {  //找左边界
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {  //找到边界跳出循环
                        x = mid;
                        break;
                    }else{
                        end = mid - 1;  //往左逼近
                    }
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }

            start = 0;
            end = nums.length - 1;
            while (start <= end) {  //找右边界
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length-1 || nums[mid+1] != target) { //找到边界跳出循环
                        y = mid;
                        break;
                    }else{
                        start = mid + 1; //往右逼近
                    }
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }

            return new int[]{x, y};
        }


        //O(n)
        public int[] searchRange0(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int x = -1;
            int y = -1;
            while (start <= end) {
                if (nums[start] == target) {
                    if (x == -1) {
                        x = start;
                    }
                }else {
                    start++;
                }
                if (nums[end] == target) {
                    if (y == -1) {
                        y = end;
                    }
                }else {
                    end--;
                }
                if (x != -1 && y != -1 && nums[x] == target && nums[y] == target) {
                    break;
                }
            }
            return new int[]{x, y};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}