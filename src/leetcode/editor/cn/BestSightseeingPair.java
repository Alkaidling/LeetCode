package leetcode.editor.cn;

//1014、最佳观光组合
class BestSightseeingPair {
    public static void main(String[] args) {
        Solution solution = new BestSightseeingPair().new Solution();
        //int[] values = {2,7,7,2,1,7,10,4,3,3};
        //int[] values = {1,2,2};
        //int[] values = {32,64,87,32,9,5,33,78,12,98,34,87,3,32,56,12,38,5,27,93};
        //int[] values = {4,7,5,8};
        int[] values = {6, 3, 7, 4, 7, 6, 6, 4, 9};
        int i = solution.maxScoreSightseeingPair(values);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        public int maxScoreSightseeingPair(int[] values) {
            return 0;
        }

        //public int maxScoreSightseeingPair(int[] values) {
        //    int n = values.length;
        //    int score = values[0] + values[1] - 1;
        //    int max = score;
        //    for (int i = 1; i < n; i++) {
        //        // 假设我们已知前一个节点 j 能组成的最大的组合为（i，j），
        //        // 那么紧接着的一个节点 j+1 最大得分的组合一定是（i，j+1）和（j，j+1）这两个组合中较大的一个。
        //        score = Math.max(values[i] + values[i-1] - 1,score - values[i-1] + values[i] - 1);
        //        max = Math.max(max,score);
        //    }
        //    return max;
        //}
        //
        //public int maxScoreSightseeingPair1(int[] values) {
        //    int n = values.length;
        //    int left = values[0];
        //    int max = Integer.MIN_VALUE;
        //    for (int i = 1; i < n; i++) {
        //        max = Math.max(max,left + values[i]-i);  // "A[i]+i+A[j]−j" 拆成 i 和 j 两部分，一个在变时另一个不变。
        //        left = Math.max(left,values[i]+i);
        //    }
        //    return max;
        //}

        //O(n²)			Time Limit Exceeded
        //public int maxScoreSightseeingPair(int[] values) {
        //    int n = values.length;
        //    int max = values[0] + values[1] - 1;
        //    for (int first = 0; first < n-1; first++) {
        //        for (int second = first+1; second < n; second++) {
        //            max = Math.max(max,values[first] + values[second] + first - second);
        //        }
        //    }
        //    return max;
        //}

        //❌
        //public int maxScoreSightseeingPair(int[] values) {
        //    int n = values.length;
        //    int first = 0;
        //    int second = 1;
        //    int max = values[first] + values[second] + first - second;
        //    for (int i = 2; i < n; i++) {
        //        if (values[i] >= values[first]) {
        //            if (values[first] - values[second] > second - first) {
        //                second = i;
        //            } else {
        //                first = second;
        //                second = i;
        //            }
        //        } else if (values[i] >= values[second]) {
        //            second = i;
        //        }
        //        max = Math.max(max, values[first] + values[second] + first - second);
        //    }
        //    return max;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}