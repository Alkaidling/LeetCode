package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-23 16:46
 * @ClassName BinarySearch
 * @Description: 二分查找
 */

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int num = Integer.parseInt(s[1]);
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        ArrayList<int[]> ints = new ArrayList<>();
        while (num > 0) {
            int target = Integer.parseInt(reader.readLine());
            int[] res = binarySearch(nums, target);
            ints.add(res);
            num--;
        }
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[] binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            int start = left;
            left = 0;
            right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return new int[]{start, right};
        }
    }

    private static int bSearch0(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;  //mid可能为结果
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private static int bSearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //先加1再除以2是为了让中间值靠右
            //(left+right)/2都是向下取整，如果不加上1，left=mid会死循环
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;  //mid可能为结果
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private static int bSearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
