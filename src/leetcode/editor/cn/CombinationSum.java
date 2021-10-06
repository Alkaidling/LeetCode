package leetcode.editor.cn;

import java.util.*;

//39、组合总和
class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] nums = {2,3, 6,7};
        List<List<Integer>> lists = solution.combinationSum(nums, 14);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            dfs(candidates, lists, target, 0,0, list);

            return lists;
        }

        //candidates：原数组，lists：结果集，target：所求和，index：当前元素在数组中的位置，sum：当前list所有元素的和，list：当前求和的元素集合
        private void dfs(int[] candidates, List<List<Integer>> lists, int target, int index,int sum, List<Integer> list) {
            if (sum == target) {
                lists.add(new ArrayList<>(list));
            } else if (sum < target) {
                for (int i = index; i < candidates.length; i++) { //i = index 确保无重复
                    list.add(candidates[i]);
                    sum += candidates[i];
                    dfs(candidates,lists,target,i,sum,list);
                    list.remove(list.size() - 1); //回溯：集合移除当前元素，sum减去当前元素，继续循环
                    sum -= candidates[i];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}