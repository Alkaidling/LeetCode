package leetcode.editor.cn;
//Java：剑指 Offer 04、二维数组中的查找
class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        //int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //int[][] matrix = {{1}};
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        long start = System.currentTimeMillis();
        boolean b = solution.findNumberIn2DArray(matrix, 15);
        long end = System.currentTimeMillis();
        System.out.println(b);
        System.out.println(start - end);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //从右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
    //O(m+n)
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    //二维数组二分查找 O(log(mn))
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        return findByBinary(matrix,0,n,0,m,target);
    }
    //二分查找  nStart,nEnd：起始行和结束行，mStart,mEnd：起始列和结束列
    public boolean findByBinary(int[][] matrix,int nStart,int nEnd,int mStart,int mEnd,int target){
        while (nEnd >= nStart && mEnd >= mStart) {
            int nMid = (nEnd-nStart)/2 + nStart;  //中间行
            int mMid = (mEnd-mStart)/2 + mStart;  //中间列
            //因为查找中间位置右上时包含了中间值所在的行和列，所有会有起始、结束、中间三个位置相等的情况，则直接比较目标值与该位置的值
            if(nMid == nStart && nMid == nEnd && mMid == mStart && mMid == mEnd){
                return target == matrix[nMid][mMid];
            }
            if(target > matrix[nMid][mMid]){
                //目标值大于中间值，则依次查找中间位置的右上、左下、右下
                return findByBinary(matrix,nStart,nMid,mMid+1,mEnd,target)
                        || findByBinary(matrix,nMid+1,nEnd,mStart,mMid,target)
                        || findByBinary(matrix,nMid+1,nEnd,mMid+1,mEnd,target);
            }else if(target < matrix[nMid][mMid]){
                //目标值小于中间值，则依次查找中间位置的右上、左下、右上(包含中间值所在的行和列)
                return findByBinary(matrix,nStart,nMid-1,mMid+1,mEnd,target)
                        || findByBinary(matrix,nMid+1,nEnd,mStart,mMid-1,target)
                        || findByBinary(matrix,nStart,nMid,mStart,mMid,target);
            }else if(target == matrix[nMid][mMid]){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}