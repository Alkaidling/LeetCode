package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-24 16:38
 * @ClassName ReverseNum
 * @Description: 逆序对的数量
 */

public class ReverseNum {
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        mergeSort(nums,0,n-1);
        System.out.print(res);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int k = 0, i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else {
                res += (mid - i + 1); //右边数组中的所有值都为nums[j]的逆序
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left,j = 0; i <= right; i++,j++) {
            nums[i] = temp[j];
        }
    }
}
