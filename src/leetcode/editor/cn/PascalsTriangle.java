package leetcode.editor.cn;

import java.util.ArrayList;
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
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(0,1);

            for (int j = 1; j < i; j++) {
                inner.add(j,list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }

            if(i>0)
                inner.add(i,1);
            list.add(inner);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}