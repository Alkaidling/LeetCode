package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：118、杨辉三角
class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        List<List<Integer>> generate = solution.generate(5);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> generate(int numRows) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            list.add(Arrays.asList(1));
            for (int i = 1; i < numRows; i++) {
                ArrayList<Integer> rowList = new ArrayList<>();
                rowList.add(1);
                for (int j = 1; j < i; j++) {
                    rowList.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
                rowList.add(1);
                list.add(rowList);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}