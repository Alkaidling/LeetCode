package leetcode.editor.cn;

//剑指 Offer 53 - II、0～n-1中缺失的数字
class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int i = solution.missingNumber(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == mid){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            return left;
        }

        //O(logn)
        public int missingNumber2(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[right] == right ? right + 1 :  right;
        }

        //O(n)
        public int missingNumber1(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}