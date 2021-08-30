package leetcode.editor.cn;

import java.util.Arrays;

//Java：528、按权重随机选择
class RandomPickWithWeight {
    public static void main(String[] args) {
        int[] w = {1,3};
        Solution solution = new RandomPickWithWeight().new Solution(w);
        int i = solution.pickIndex();
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] arr;
    private int len = 0;
    private double sum = 0.0;

    public Solution(int[] w) {
        this.arr = w;
        len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }

    }
    public int pickIndex() {
        if(len == 1)
            return 0;

        //随机数
        double r = Math.random();

        //概率区间
        double[] p = new double[len];
        //计算概率区间
        for (int i = 0; i < len; i++) {
            if(i == 0)
                p[i] = arr[i]/sum;
            else
                p[i] = p[i-1] + arr[i]/sum;
        }

        if(r<=p[0])
            return 0;

        for (int i = 1; i < len; i++) {
            //随机数落到概率区间则返回该值
            if(p[i-1] <= r && r <= p[i])
                return i;
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}