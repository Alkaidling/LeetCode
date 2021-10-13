package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//412、Fizz Buzz
class FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
        List<String> strings = solution.fizzBuzz(15);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    list.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    list.add("Fizz");
                } else if (i % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(""+i);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}