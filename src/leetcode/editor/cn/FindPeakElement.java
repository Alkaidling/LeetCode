package leetcode.editor.cn;

//Java：162、寻找峰值
class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        int[] nums = {1,2,3,1};
        int peakElement = solution.findPeakElement1(nums);
        System.out.println(peakElement);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findPeakElement(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            int mid;
            if (end == start) {
                return 0;
            }
            while (start <= end) {  //start <= end 结束循环时start为峰顶
                mid = start + (end - start)/2;
                if((mid == 0 && nums[mid] > nums[mid+1]) || (mid == nums.length-1 && nums[mid] > nums[mid-1])){
                    return mid;
                }
                if(nums[mid] < nums[mid+1]){
                    start = mid + 1;  //开区间
                }else if(nums[mid-1] > nums[mid]){
                    end = mid - 1;
                }else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                    return mid;
                }
            }
            return start;
        }

        public int findPeakElement1(int[] nums) {
            int n = nums.length;
            int start = 0, end = n - 1;
            while (start < end) { //结束循环时start==end为峰顶
                int mid = ((end - start) >> 1) + start;
                if (nums[mid] > nums[mid + 1]) {
                    end = mid;  //此时mid可能为峰顶，所以要闭区间
                } else {
                    start = mid + 1;  //此时mid不可能为峰顶，所以不用包含mid
                }
            }
            return end;
        }

        public int findPeakElement0(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid = 0;
            while (start <= end) {
                mid = ((end - start) >> 1) + start;
                if (mid > 0 && mid < nums.length - 1) {
                    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                        break;
                    } else if (nums[mid] < nums[mid + 1]) {  //上坡必有坡顶(右边区间一定满足，左区间可能满足)
                        start = mid + 1;
                    } else if (nums[mid - 1] > nums[mid]) {
                        end = mid - 1;
                    }
                } else if (mid == 0) {
                    if (nums[0] < nums[1]) {
                        mid = 1;
                        break;
                    } else {
                        break;
                    }
                } else if (mid == nums.length - 1) {
                    break;
                }
            }
            return mid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}