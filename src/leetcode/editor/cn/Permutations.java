package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//46、全排列
class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            dfs(nums,0, lists, list);

            return lists;
        }

        //nums：数组，n：list中的个数，lists：结果集，list：当前结果集合
        private void dfs(int[] nums, int n,List<List<Integer>> lists, ArrayList<Integer> list) {
            if (n == nums.length) {
                lists.add(new ArrayList<>(list));
            }else {
                for (int num : nums) {
                    if(!list.contains(num)) {
                        list.add(num);
                        dfs(nums,n+1,lists,list);  //递归
                        list.remove(list.size()-1); //回溯
                    }
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}