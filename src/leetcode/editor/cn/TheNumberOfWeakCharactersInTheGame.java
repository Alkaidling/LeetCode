package leetcode.editor.cn;

import java.util.*;

//1996、游戏中弱角色的数量
class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
        //System.out.println(solution.numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            int res = 0;
            ArrayDeque<int[]> stack = new ArrayDeque<>();
            Arrays.sort(properties,(a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            for (int[] property : properties) {
                while (!stack.isEmpty() && stack.peek()[1] < property[1]) {
                    stack.pop();
                    res++;
                }
                stack.push(property);
            }
            return res;
        }

        public int numberOfWeakCharacters0(int[][] properties) {
            int res = 0 ,max = 0;
            Arrays.sort(properties,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            for (int[] property : properties) {
                if (property[1] < max) {
                    res++;
                }else {
                    max = property[1];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}