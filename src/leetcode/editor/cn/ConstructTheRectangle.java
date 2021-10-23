package leetcode.editor.cn;

import java.util.Arrays;

//492、构造矩形
class ConstructTheRectangle {
    public static void main(String[] args) {
        Solution solution = new ConstructTheRectangle().new Solution();
        int[] ints = solution.constructRectangle(400);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //O(sqrt(area))
        public int[] constructRectangle(int area) {
            int x = (int) Math.sqrt(area);
            while (area % x != 0) {
                x--;
            }
            return new int[]{area/x,x};
        }

        //O(area)
        //执行耗时:912 ms,击败了5.18% 的Java用户 内存消耗:35.3 MB,击败了100.00% 的Java用户
        public int[] constructRectangle0(int area) {
            int length = 0;
            int weight = 0;
            for (int w = 1; w*w <= area; w++) {
                for (int l = w; l*w <= area; l++) {
                    if (w * l == area) {
                        length = l;
                        weight = w;
                    }
                }
            }
            return new int[]{length, weight};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}