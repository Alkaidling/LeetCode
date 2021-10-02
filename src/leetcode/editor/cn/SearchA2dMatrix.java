package leetcode.editor.cn;
//74、搜索二维矩阵
class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] matrix = {{1}};
        boolean b = solution.searchMatrix(matrix, 1);
        System.out.println(b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int index = -1;  //target所在行
        int start = 0;
        int end = row - 1;
        int mid;
        while (start <= end) {  //二分判断在哪一行
            mid = start + (end - start)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][col-1]) {
                index = mid;
                break;
            }else if(target > matrix[mid][col-1]){
                start = mid + 1;
            }else if(target < matrix[mid][0]){
                end = mid - 1;
            }
        }
        if (index < 0) {  //target大于矩阵最大值 或 小于矩阵最小值
            return false;
        }
        start = 0;
        end = col - 1;
        while (start <= end) {  //二分在所在行中查找
            mid = start + (end - start)/2;
            if (matrix[index][mid] > target) {
                end = mid - 1;
            } else if (matrix[index][mid] < target) {
                start = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}