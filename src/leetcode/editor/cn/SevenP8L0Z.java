package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 084、含有重复元素集合的全排列 
class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
                if(visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])){
                    continue;
                }
                list.add(nums[i]);
                visit[i] = true;
                dfs(nums,visit,list,lists);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}