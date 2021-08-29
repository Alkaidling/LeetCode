package leetcode.editor.cn;
//Java：1588、所有奇数长度子数组的和
class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
        int[] arr = {1,4,2,5,3};
        int i = solution.sumOddLengthSubarrays1(arr);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //前缀和
        public int sumOddLengthSubarrays1(int[] arr) {
            int n = arr.length;
            int[] prefixSums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSums[i + 1] = prefixSums[i] + arr[i];  //prefixSums[i] 表示 arr 从下标 0 到下标i−1 的元素和。
            }
            int sum = 0;
            for (int start = 0; start < n; start++) {
                for (int length = 1; start + length <= n; length += 2) {
                    int end = start + length - 1;
                    sum += prefixSums[end + 1] - prefixSums[start];  //arr 的下标范围[start,end] 的子数组的和，从end
                }
            }
            return sum;
        }

    public int sumOddLengthSubarrays(int[] arr) {

        //计算一个数字在多少个奇数长度的数组中出现过
        //每个数字一共在 left_even * right_even + left_odd * right_odd 个奇数长度的数组中出现过
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            //leftCount 左边可选择的个数       rightCount         右边可选择的个数
            //leftEven  左边偶数个可选择的方案  rightEven    右边偶数个可选择的方案
            //leftOdd   左边奇数个可选择的方案  rightOdd     右边奇数个可选择的方案
            int leftCount = i, rightCount = arr.length - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }

        //暴力法 O(n) = n³
        int result = 0;
        int len = arr.length;
        int n = 1;
        while (n <= len) {
            //求长度为n的子序和
            for (int i = 0; i < len; i++) {
                int temp = i;
                //子序列从temp位置开始，长度为n
                // n+i<=len 子序末位不超总长度
                if(temp < n+i && n+i<=len){
                    for (; temp < n+i; temp++) { //循环添加
                        result += arr[temp];
                    }
                }
            }

            n += 2;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}