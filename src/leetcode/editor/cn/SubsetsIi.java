package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90、子集 II
class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        int[] nums = {1,2,2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
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
                //同47题
                //visit[i-1]为false指经过了一次递归在44行将i-1的元素置为false，此时继续for循环所以不能用i元素
                //visit[i-1]为true指在42行进入递归，i-1和i放置的 位置 并不是同一个，所以此时可以用i元素
                if(i>0 && nums[i] == nums[i-1] && !visit[i-1]){
                    continue;
                }
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