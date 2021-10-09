package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//781、森林中的兔子
class RabbitsInForest {
    public static void main(String[] args) {
        Solution solution = new RabbitsInForest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:3 ms,击败了66.64% 的Java用户 内存消耗:37.7 MB,击败了66.12% 的Java用户
        public int numRabbits(int[] answers) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int res = 0;
            for (int i = 0; i < answers.length; i++) {
                map.put(answers[i],map.getOrDefault(answers[i],0)+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if (val > key + 1) {  //超过key+1兔子回答同一个数，分组处理
                    int temp = 0;
                    //简化
                    //val = (val + key) / (key+1);  //向上取整
                    //while (val > key){
                    //    val = val - key - 1;  //每次减去key+1个的兔子，构成一组
                    //    temp++;
                    //}
                    temp = val / (key-1);
                    if (val%(key+1) > 0) {  //如果有余数则余数为一组
                        temp++;
                    }
                    res = res + temp*(key+1);  //temp组，每组key+1
                }else {
                    res = res + key + 1;  //val不超过key+1 则直接加上key+1
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}