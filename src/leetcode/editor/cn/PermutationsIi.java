package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47、全排列 II
class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] booleans = new boolean[nums.length];
            dfs(nums, 0, lists, list,booleans);

            return lists;
        }

        //nums：数组，n：list中的个数，lists：结果集，list：当前结果集合
        private void dfs(int[] nums, int n, List<List<Integer>> lists, ArrayList<Integer> list,boolean[] visit) {
            if (n == nums.length) {
                lists.add(new ArrayList<>(list));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    //如果i位置标记过（已加到list中）  或者  当i重复时，且i-1未标记时跳过循环（也就是两个相同的数，只有前一个访问过，才去访问后一个，确保之访问这一次）

                    //for循环保证了从数组中从前往后一个一个取值，再用if判断条件。所以nums[i - 1]一定比nums[i]先被取值和判断。
                    // 如果nums[i - 1]被取值了，那vis[i - 1]会被置1，只有当递归再回退到这一层时再将它置0。
                    // 每递归一层都是在寻找数组对应于递归深度位置的值，每一层里用for循环来寻找。

                    // 所以当vis[i - 1] == 1时（回溯前进dfs）说明nums[i - 1]和nums[i]分别属于两层递归中，
                    // 也就是我们要用这两个数分别放在数组的两个位置，这时不需要去重。

                    // 但是当vis[i - 1] == 0时（回溯完）说明nums[i - 1]和nums[i]属于同一层递归中（只是for循环进入下一层循环），
                    // 也就是我们要用这两个数放在数组中的同一个位置上，这就是我们要去重的情况。
                    if(visit[i] || (i>0 && nums[i] == nums[i-1] && !visit[i-1])){
                        continue;
                    }
                    list.add(nums[i]);
                    visit[i] = true;  //list中加的值，则访问数组标记
                    dfs(nums, n + 1, lists, list,visit);  //递归
                    list.remove(list.size() - 1); //回溯
                    visit[i] = false; //回溯后，值抹去，标记清除
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}