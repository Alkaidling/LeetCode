package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Stream;

//剑指 Offer II 037、小行星碰撞
class XagZNi {
    public static void main(String[] args) {
        Solution solution = new XagZNi().new Solution();
        int[] ints = solution.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int ast : asteroids) {
                collision : {
                    while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                        if (stack.peek() < -ast) {
                            stack.pop();
                            continue;
                        } else if (stack.peek() == -ast) {
                            stack.pop();
                        }
                        break collision;
                    }
                    stack.push(ast);
                }
            }
            int[] ans = new int[stack.size()];
            for (int t = ans.length - 1; t >= 0; --t) {
                ans[t] = stack.pop();
            }
            return ans;
        }

        public int[] asteroidCollision0(int[] asteroids) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i : asteroids) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else if (stack.peek() > 0 && i < 0) {
                    boolean flag = false;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        if (Math.abs(i) == Math.abs(stack.peek())) {
                            flag = true;
                            stack.pop();
                            break;
                        } else if (Math.abs(i) > Math.abs(stack.peek())) {
                            stack.pop();
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }

            }
            int[] res = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                res[i++] = stack.pollLast();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}