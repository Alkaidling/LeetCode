package leetcode.editor.cn;
//Java：剑指 Offer 13、机器人的运动范围
class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        int i = solution.movingCount(2, 3, 1);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        int ans = visitCount(visit,m,n,0,0,k);
        return ans;
    }

    private int visitCount(boolean[][] visit, int m, int n, int row, int col, int k) {
    int count = 0;
        if(row/10 + row%10 + col/10 + col%10 <= k  && row >= 0 && col >= 0 && row < m && col < n && !visit[row][col]) {
            visit[row][col] = true;
            count = 1+visitCount(visit,m,n,row+1,col,k)
                    + visitCount(visit,m,n,row,col+1,k);
                    //+ visitCount(visit,m,n,row-1,col,k)
                    //+ visitCount(visit,m,n,row,col-1,k); //只需往下遍历，不考虑多条路径（剑指 Offer 12）
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}