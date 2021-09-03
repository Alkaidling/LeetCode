package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

//Java：面试题 17.14、最小K个数
class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] arr = {1,3,5,7,2,4,6,8};
        //int[] ints = solution.smallestK(arr, 4);
        //System.out.println(Arrays.toString(ints));
        solution.quickSort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //1快排思想
        public int[] smallestK(int[] arr, int k) {
            randomizedSelected(arr, 0, arr.length - 1, k);
            int[] vec = new int[k];
            for (int i = 0; i < k; ++i) {
                vec[i] = arr[i];
            }
            return vec;
        }

        private void randomizedSelected(int[] arr, int l, int r, int k) {
            if (l >= r) {
                return;
            }
            int pos = randomizedPartition(arr, l, r);
            int num = pos - l + 1;
            if (k == num) { //分界点等于k直接返回
                return;
            } else if (k < num) {  //分界点pos大于k，则在前pos-1个数找k个
                randomizedSelected(arr, l, pos - 1, k);
            } else {  //分界点pos小于k，则在pos+1之后找k-num个
                randomizedSelected(arr, pos + 1, r, k - num);
            }
        }

        // 基于随机的划分
        private int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + l;
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        //2快排
        public int[] smallestK2(int[] arr, int k) {
            this.quickSort(arr,0,arr.length-1);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = arr[i];
            }
            return result;
        }


        public void quickSort1(int[] arr,int low,int high) {
            int i, j, temp;
            if (low >= high) {
                return;
            }
            i = low;
            j = high;
            //temp就是基准位
            temp = arr[low];

            while (i < j) {
                //先看右边，依次往左递减
                while (temp <= arr[j] && i < j) {
                    j--;
                }
                //再看左边，依次往右递增
                while (temp >= arr[i] && i < j) {
                    i++;
                }
                //如果满足条件则交换
                if (i < j) {
                    swap(arr,i,j);
                }

            }
            //最后将基准为与i和j相等位置的数字交换
            arr[low] = arr[i];
            arr[i] = temp;
            //递归调用左半数组
            quickSort1(arr, low, j - 1);
            //递归调用右半数组
            quickSort1(arr, j + 1, high);
        }

        public void quickSort(int[] arr,int left,int right){
            int temp;
            int low = left;
            int high = right;

            if (left < right) {

                temp = arr[left];

                while (low < high) {
                    while (high>low && arr[high] >= temp)
                        --high;
                    if (low < high) {
                        arr[low] = arr[high];
                        ++low;
                    }
                    while (low<high && arr[low] < temp)
                        ++low;
                    if (low < high) {
                        arr[high] = arr[low];
                        --high;
                    }
                }

                arr[low] = temp;
                quickSort(arr,left,low-1);
                quickSort(arr,low+1,right);
            }
        }


        //3优先队列
    public int[] smallestK1(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[k];
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}