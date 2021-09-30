package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18、四数之和
class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = {2, 2, 2, 2, 2};
        List<List<Integer>> lists = solution.fourSum(nums, 8);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n³)
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // 去除相同的数。
                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int i = j + 1; i < n - 1; i++) {
                    // 去除相同的数。
                    if (i > j + 1 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    int start = i + 1;
                    int end = n - 1;
                    while (start < end) {
                        if (nums[j] + nums[i] + nums[start] + nums[end] == target) {
                            lists.add(Arrays.asList(nums[j], nums[i], nums[start], nums[end]));
                            //判断左界和右界是否和下一位置重复，去除重复解。
                            while (start < end && nums[start] == nums[start + 1]) {
                                start++;
                            }
                            while (start < end && nums[end] == nums[end - 1]) {
                                end--;
                            }
                            //将 start,end 移到下一位置，寻找新的解
                            start++;
                            end--;
                        } else if (nums[j] + nums[i] + nums[start] + nums[end] < target) {
                            start++;
                        } else if (nums[j] + nums[i] + nums[start] + nums[end] > target) {
                            end--;
                        }
                    }
                }
            }
            return lists;
        }

        //O(n^4)
        public List<List<Integer>> fourSum1(int[] nums, int target) {
            List<List<Integer>> resp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    for(int k=j+1;k<nums.length;k++){
                        for(int l=k+1;l<nums.length;l++){
                            if(nums[i]+nums[j]+nums[k]+nums[l] == target){
                                List<Integer> ans = Arrays.asList(nums[j], nums[i], nums[k], nums[l]);
                                if(!resp.contains(ans)){
                                    resp.add(ans);
                                }
                            }
                        }
                    }
                }
            }
            return resp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}