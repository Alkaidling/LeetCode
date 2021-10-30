package leetcode.editor.cn.acwing.b;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-30 15:05
 * @ClassName HeapSort
 * @Description: 堆排序
 */

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int size = n;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            down(arr, i, size);
        }

        while (m-- > 0) {
            System.out.print(arr[0] + " ");
            arr[0] = arr[size - 1];
            size--;
            down(arr, 0, size);
        }
    }

    private static void down(int[] arr, int i, int n) {
        int c1 = 2 * i + 1, c2 = 2 * i + 2;
        int min = i;
        if (c1 < n && arr[c1] < arr[min]) {
            min = c1;
        }
        if (c2 < n && arr[c2] < arr[min]) {
            min = c2;
        }

        if (i != min) {
            swap(arr, i, min);
            down(arr, min, n);
        }
    }

    public static void swap(int[]arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
