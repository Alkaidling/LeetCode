package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 106、二分图
class VEAB3K {
    public static void main(String[] args) {
        Solution solution = new VEAB3K().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    if(!dfs(graph,color,i,1)){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int[] color, int i, int c) {
            color[i] = c;
            int[] nums = graph[i];
            if (nums.length == 0) {
                return true;
            }
            for (int num : nums) {
                if (color[num] == 0) {
                    if (!dfs(graph, color, num, 3 - c)) {
                        return false;
                    }
                }else if(color[num] == c){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}