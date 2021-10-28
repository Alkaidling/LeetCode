package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 15:00
 * @ClassName IsSubNums
 * @Description: 2816. 判断子序列
 */

public class IsSubNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] str1 = reader.readLine().split(" ");
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(str1[i]);
        }
        String[] str2 = reader.readLine().split(" ");
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.parseInt(str2[i]);
        }

        boolean b = isSubNums(nums1,nums2);

        if (b){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    //判断nums1是否是nums2的子序列
    private static boolean isSubNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j == n) {
                return true;
            }
            if(nums2[i] == nums1[j]){
                j++;
            }
        }
        return j == n;
    }
}
