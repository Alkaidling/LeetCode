package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15、三数之和
class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> lists = solution.threeSum(nums);
        List<List<Integer>> lists1 = solution.threeSum1(nums);
        System.out.println(lists);
        System.out.println(lists1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //时间复杂度O(n²)
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < n-1; i++) {
                // 去除相同的数。
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int start = i+1;
                int end = n-1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        //lists.contains耗时太长！不能用作去重
                        //if(!lists.contains(Arrays.asList(nums[i], nums[start], nums[end]))){
                        //    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        //}
                        lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        //判断左界和右界是否和下一位置重复，去除重复解。
                        while (start < end && nums[start] == nums[start+1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        //将 start,end 移到下一位置，寻找新的解
                        start++;
                        end--;
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    }else if(nums[i] + nums[start] + nums[end] > 0){
                        end--;
                    }
                }
            }

            return lists;
        }



        //Time Limit Exceeded 时间复杂度O(n³)
        public List<List<Integer>> threeSum1(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    for (int k = j+1; k < n; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                            if(!lists.contains(list)){
                                lists.add(list);
                            }
                        }
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}