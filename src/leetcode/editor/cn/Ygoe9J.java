package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 081、允许重复选择元素的组合
class Ygoe9J {
    public static void main(String[] args) {
        Solution solution = new Ygoe9J().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            dfs(candidates,target,0,0,list,lists);
            return lists;
        }

        private void dfs(int[] candidates, int target, int sum, int index, ArrayList<Integer> list, ArrayList<List<Integer>> lists) {
            if (sum == target) {
                lists.add(new ArrayList<>(list));
            } else if (sum < target) {
                for (int i = index; i < candidates.length; i++) {
                    sum += candidates[i];
                    list.add(candidates[i]);
                    dfs(candidates,target,sum,i,list,lists);
                    sum -= candidates[i];
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}