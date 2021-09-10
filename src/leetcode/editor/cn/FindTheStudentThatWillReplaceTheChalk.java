package leetcode.editor.cn;
//Java：1894、找到需要补充粉笔的学生编号
class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        Solution solution = new FindTheStudentThatWillReplaceTheChalk().new Solution();
        int[] chalk = {5,1,5,4,9,9,9,8,7,1,3,2,4,5,6,7,3,22,35,67,3,1,44,79,12,2,58,2,11,33,12,10,1,3,6,5,4,1,2,3,1,3,2,4,5,6,1,7,3,6,7,8,9,3,6,6,7,1,1,2,6,8,9,10,23,5,4,8,4,1,3,1,5,6,7,9,14,41,3,3,2,6,7,3,3,3,3,1,1,3,5,6,2,2,8,1,6,8,9};
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if(k < chalk[i]){
                return i;
            }
            k -= chalk[i];
            //if(i == chalk.length - 1){
            //    k -= chalk[i];
            //    if(k < 0){
            //        return i;
            //    }
            //    if(k < chalk[0] || k == 0){
            //        return 0;
            //    }
            //}else {
            //    k -= chalk[i];
            //    if(k < 0){
            //        return i;
            //    }
            //    if(k < chalk[i+1] || k == 0){
            //        return i+1;
            //    }
            //}
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}