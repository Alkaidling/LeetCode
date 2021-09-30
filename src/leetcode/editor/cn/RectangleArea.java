package leetcode.editor.cn;

//223、矩形面积
class RectangleArea {
    public static void main(String[] args) {
        Solution solution = new RectangleArea().new Solution();
        int i = solution.computeArea(-2, -2, 2, 2, 1, 1, 3, 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int aArea = (ax2 - ax1) * (ay2 - ay1);  //A面积
            int bArea = (bx2 - bx1) * (by2 - by1);  //B面积
            int conArea;  //重合区域面积

            //A在B(B在A)的上、下、左、右四种情况下无重合
            if (bx1 > ax2 || by2 < ay1 || bx2 < ax1 || by1 > ay2) {
                conArea = 0;
            }else {
                //A和B右侧的边的最小值 即为 重合矩形的右边界。A和B左侧的边的最大值 即为 重合矩形的左边界
                int conX = Math.min(bx2,ax2) - Math.max(ax1,bx1);
                //A和B上侧的边的最小值 即为 重合矩形的上边界。A和B下侧的边的最大值 即为 重合矩形的下边界
                int conY = Math.min(by2,ay2) - Math.max(by1,ay1);
                conArea = conX * conY;
            }

            return aArea + bArea - conArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}