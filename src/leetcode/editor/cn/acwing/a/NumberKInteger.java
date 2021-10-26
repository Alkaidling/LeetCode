package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-24 16:25
 * @ClassName NumberKnums
 * @Description: 第k个数
 */

public class NumberKInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        quickSort(nums, 0, n - 1);
        System.out.print(nums[k - 1]);
        System.out.println(quickSort(nums,0, n-1, k-1));

    }

    static int N = 100010;

    public static int quickSort(int[] nums,int l, int r, int k){
        if(l >= r) {
            return nums[k];
        }

        int x = nums[l], i = l-1, j = r+1;
        while(i < j) {
            do {
                i++;
            } while(nums[i] < x);
            do {
                j--;
            } while(nums[j] > x);
            if(i < j) {
                swap(nums, i, j);
            }
        }

        if(k <= j) {
            return quickSort(nums,l, j, k);
        } else {
            return quickSort(nums,j+1, r, k);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int x = nums[left];
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
