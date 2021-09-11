package leetcode.editor.cn;
//Java：600、不含连续1的非负整数
class NonNegativeIntegersWithoutConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new NonNegativeIntegersWithoutConsecutiveOnes().new Solution();
        int integers = solution.findIntegers(5);
        System.out.println(integers);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findIntegers(int n) {
        int ans = 0;
        for(int i = 0; i <= n; ++i){
            if((i & (i >> 1)) == 0){
                ans++;
            }
        }
        return ans;
    }

        //OutOfMemory
    public int findIntegers1(int n) {
        int ans = 0;
        int[] ints = new int[n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < 32; j++) {
                if(i > Math.pow(2,j) && i < Math.pow(2,j+1)){
                    if(i >= Math.pow(2,j) + Math.pow(2,j-1)){  //将11开头的都标记为1
                        ints[i] = 1;
                        continue;
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < 32; j++) {
                if(i > Math.pow(2,j) && i < Math.pow(2,j+1)){
                    if(ints[i] == 0){
                        int temp = (int) (i - Math.pow(2,j)); //将10开头的减去2的j次方，如果差值被标记过则标记当前值
                        if(ints[temp] == 1){
                            ints[i] = 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {  //所有被标记的数量
            ans += ints[i];
        }
        return n - ans + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}