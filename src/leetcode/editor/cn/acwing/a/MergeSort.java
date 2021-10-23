package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-23 16:08
 * @ClassName MergeSort
 * @Description: 归并排序
 */

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        mergeSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);   //递归
        mergeSort(nums, mid + 1, right);
        //递归之后此时nums中 left到mid 和 mid到right 都是有序的
        int k = 0, i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];  //存放l到r区间排序结果
        while (i <= mid && j <= right) {  //归并
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {    //多余的直接加到temp中
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left,j = 0; i <= right; i++,j++) { //排序结果转回nums数组
            nums[i] = temp[j];
        }
    }
}
