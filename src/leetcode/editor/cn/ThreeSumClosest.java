package leetcode.editor.cn;

import java.util.Arrays;

//16、最接近的三数之和
class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        //int[] nums = {-1, 2, 1, -4, 4, 8, -2, 3, -3, 5, 7};
        //int[] nums = {-1, 0, 1, 1, 55};
        int[] nums = {0, 0, 0};
        int i = solution.threeSumClosest(nums, 1);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n²)
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int sum;
            int div = Integer.MAX_VALUE;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                // 去除相同的数。
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int start = i+1;
                int end = n-1;
                while (start < end) {
                    sum = nums[i] + nums[start] + nums[end];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(div)) {
                        div = sum-target;
                        ans = sum;
                    }
                    //将 start,end 移到下一位置，寻找新的解

                    //if(sum < target){  //去重操作，避免计算重复解
                    //    int start0 = start + 1;
                    //    while (start0 < end && nums[start0] == nums[start]) {
                    //        ++start0;
                    //    }
                    //    start = start0;
                    //} else if(sum > target){ //移动end指针
                    //    int end0 = end - 1;
                    //    while (start < end0 && nums[end] == nums[end0]) {
                    //        --end0;
                    //    }
                    //    end = end0;
                    //}
                    if(sum < target){
                        start++;
                    }
                    else if(sum > target){
                        end--;
                    }
                }
            }
            return ans;
        }



        //O(n³)
        public int threeSumClosest1(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int sum;
            int div = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        sum = nums[i] + nums[j] + nums[k];
                        if (Math.abs(sum - target) < Math.abs(div)) {
                            div = sum - target;
                            ans = sum;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}