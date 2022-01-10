package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 080、含有 k 个元素的组合
class UUsW3B {
    public static void main(String[] args) {
        Solution solution = new UUsW3B().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }

        public void dfs(int cur, int n, int k) {
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(cur);
            dfs(cur + 1, n, k);
            temp.remove(temp.size() - 1);
            dfs(cur + 1, n, k);
        }


        public List<List<Integer>> combine0(int n, int k) {
            boolean[] visit = new boolean[n + 1];
            dfs(n,k,1,visit);
            return ans;
        }

        private void dfs(int n, int k, int index,boolean[] visit) {
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
            }
            for (int i = index; i <= n; i++) {
                if(visit[i]) {
                    continue;
                }
                temp.add(i);
                visit[i] = true;
                dfs(n,k,i + 1,visit);
                temp.remove(temp.size() - 1);
                visit[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}