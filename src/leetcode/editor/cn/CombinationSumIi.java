package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40、组合总和 II
class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        List<List<Integer>> lists = solution.combinationSum2(candidates, 30);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);  //排序方便去重
            dfs(candidates, lists, target, -1, 0, list);

            return lists;
        }

        //candidates：原数组，lists：结果集，target：所求和，index：当前元素在数组中的位置，sum：当前list所有元素的和，list：当前求和的元素集合
        private void dfs(int[] candidates, List<List<Integer>> lists, int target, int index, int sum, List<Integer> list) {
            if (sum == target) {
                if(!lists.contains(list)){
                    lists.add(new ArrayList<>(list));
                }
            } else if (sum < target) {
                for (int i = index+1; i < candidates.length; i++) { //i = index+1 确保不会颠倒位置
                    if(i > index+1 && candidates[i] == candidates[i-1]) {  //去掉重复值
                        continue;
                    }
                    list.add(candidates[i]);
                    sum += candidates[i];
                    dfs(candidates, lists, target, i, sum, list);
                    list.remove(list.size() - 1); //回溯：集合移除当前元素，sum减去当前元素，继续循环
                    sum -= candidates[i];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}