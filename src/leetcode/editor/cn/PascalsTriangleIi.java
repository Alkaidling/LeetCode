package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：119、杨辉三角 II
class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        List<Integer> row2 = solution.getRow2(5);
        System.out.println(row2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //线性递推 时间O(rowIndex)。空间O(1)
        public List<Integer> getRow2(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }

        //线性规划  时间O(rowIndex²)。空间O(1)
        //只使用一个数组
        //当前行第 i 项的计算只与上一行第 i-1 项及第 i 项有关。
        //因此我们可以倒着计算当前行，这样计算到第 i 项时，第 i−1 项仍然是上一行的值。
        public List<Integer> getRow1(int rowIndex) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add(0);
                for (int j = i; j > 0; --j) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;
        }

        //时间O(rowIndex²)。空间O(1)
        public List<Integer> getRow(int rowIndex) {
            rowIndex++;
            ArrayList<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < rowIndex; i++) {
                ArrayList<Integer> inner = new ArrayList<>();
                inner.add(0, 1);

                for (int j = 1; j < i; j++) {
                    inner.add(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }

                if (i > 0)
                    inner.add(i, 1);
                list.add(inner);
            }
            List<Integer> resultList = list.get(rowIndex - 1);
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}