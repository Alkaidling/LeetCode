package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-23 15:13
 * @ClassName QuickSort
 * @Description: 快排
 */

public class QuickSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        quickSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int x = nums[new Random().nextInt(right - left + 1) + left];  //快排对比的值，在l到r中随机取
        //int x = nums[(left + right + 1) / 2];
        int i = left - 1, j = right + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
