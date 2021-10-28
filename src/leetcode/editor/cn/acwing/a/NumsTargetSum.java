package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 14:41
 * @ClassName NumsTargetSum
 * @Description: 800、数组元素的目标和
 */

public class NumsTargetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int target = Integer.parseInt(s[2]);
        String[] s1 = reader.readLine().split(" ");
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = reader.readLine().split(" ");
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.parseInt(s2[i]);
        }
        int[] res = numsTargetSum(nums1,nums2,target);
        System.out.println(res[0] + " " + res[1]);
        reader.close();
    }

    //O(m+n) 双指针
    private static int[] numsTargetSum(int[] nums1, int[] nums2, int target) {
        int[] res = new int[2];
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (nums1[i] + nums2[j] > target) {
                j--;
            } else if (nums1[i] + nums2[j] < target) {
                i++;
            }else {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }
}
