package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

//剑指 Offer 40、最小的k个数
class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //排序
        //执行耗时:8 ms,击败了48.79% 的Java用户 内存消耗:39.7 MB,击败了57.36% 的Java用户
        public int[] getLeastNumbers2(int[] arr, int k) {
            Arrays.sort(arr);
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }
        //堆
        //执行耗时:15 ms,击败了28.67% 的Java用户 内存消耗:39.2 MB,击败了96.70% 的Java用户
        public int[] getLeastNumbers1(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : arr) {
                queue.offer(i);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
        //执行耗时:5 ms,击败了72.67% 的Java用户 内存消耗:40 MB,击败了5.05% 的Java用户
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            quickSelect(arr,0,arr.length-1,k);
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }
        //快速选择
        public void quickSelect(int[] arr, int left, int right,int k){
            if (left >= right) {
                return;
            }
            int i = left - 1, j = right + 1;
            int x = arr[left];
            while (i < j) {
                do {
                    i++;
                }while (arr[i] < x);
                do {
                    j--;
                }while (arr[j] > x);
                if (i < j) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            //if (left < k) {
            //    quickSelect(arr,left,j,k);
            //    quickSelect(arr,j+1,right,k);
            //}
            if (j < k) {
                quickSelect(arr,j+1,right,k);
            }else{
                quickSelect(arr,left,j,k);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}