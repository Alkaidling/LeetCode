package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 082、含有重复元素集合的组合
class FourSjJUc {
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, 0,list, lists);
            return lists;
        }

        private void dfs(int[] candidates, int target, int sum, int index, ArrayList<Integer> list, ArrayList<List<Integer>> lists) {
            if (sum == target) {
                lists.add(new ArrayList<>(list));
            } else if (sum < target) {
                for (int i = index; i < candidates.length; i++) {
                    if(i > index && candidates[i] == candidates[i - 1]){
                        continue;
                    }
                    sum += candidates[i];
                    list.add(candidates[i]);
                    dfs(candidates,target,sum,i + 1,list,lists);
                    sum -= candidates[i];
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}