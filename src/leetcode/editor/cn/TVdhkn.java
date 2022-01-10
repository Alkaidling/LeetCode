package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 079、所有子集
class TVdhkn {
    public static void main(String[] args) {
        Solution solution = new TVdhkn().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] visit = new boolean[nums.length];
            dfs(nums,0,visit,list,lists);

            lists.add(new ArrayList<>());
            return lists;
        }

        private void dfs(int[] nums, int index,boolean[] visit, ArrayList<Integer> list, ArrayList<List<Integer>> lists) {
            if (!list.isEmpty()) {
                lists.add(new ArrayList<>(list));
            }
            for (int i = index; i < nums.length; i++) {
                if(visit[i]){
                    continue;
                }
                list.add(nums[i]);
                visit[i] = true;
                dfs(nums,i + 1,visit,list,lists);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}