package leetcode.editor.cn;

//剑指 Offer II 069、山峰数组的顶部
class B1IidL {
    public static void main(String[] args) {
        Solution solution = new B1IidL().new Solution();
        //int[] arr = {1, 3, 5, 6, 10, 6, 5, 4, 2, 1};
        int[] arr = {1,2,3};
        int index = solution.peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(mid < arr.length - 1 && arr[mid] < arr[mid + 1]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return left;
        }

        //O(n)
        public int peakIndexInMountainArray0(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n-1; i++) {
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    return i;
                }
            }
            return 0;
        }

        //O(log n)
        public int peakIndexInMountainArray1(int[] arr) {
            int n = arr.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (arr[mid - 1] < arr[mid]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}