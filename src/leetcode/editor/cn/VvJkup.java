package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 083、没有重复元素集合的全排列
class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] visit = new boolean[nums.length];
            dfs(nums,visit,list,lists);
            return lists;
        }

        private void dfs(int[] nums, boolean[] visit, ArrayList<Integer> list, ArrayList<List<Integer>> lists) {
            if (list.size() == nums.length) {
                lists.add(new ArrayList<>(list));
            }
            for (int i = 0; i < nums.length; i++) {
                if(visit[i]){
                    continue;
                }
                list.add(nums[i]);
                visit[i] = true;
                dfs(nums,visit,list,lists);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}