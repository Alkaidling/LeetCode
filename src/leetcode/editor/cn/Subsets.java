package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//78、子集
class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] visit = new boolean[nums.length];
            dfs(nums, lists, list, visit, 0);
            lists.add(new ArrayList<Integer>());
            return lists;
        }

        private void dfs(int[] nums, ArrayList<List<Integer>> lists, ArrayList<Integer> list, boolean[] visit, int index) {
            if (!list.isEmpty()) {
                lists.add(new ArrayList<>(list));
            }
            for (int i = index; i < nums.length; i++) {
                if (!visit[i] && list.size() < nums.length) {
                    list.add(nums[i]);
                    visit[i] = true;
                    dfs(nums, lists, list, visit, i+1);
                    list.remove(list.size() - 1);
                    visit[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}