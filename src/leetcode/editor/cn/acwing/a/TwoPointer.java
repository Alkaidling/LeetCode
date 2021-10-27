package leetcode.editor.cn.acwing.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-27 14:48
 * @ClassName TwoPointer
 * @Description: 双指针
 */

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int res = lengthOfLongestSub(nums);
        System.out.println(res);
    }

    //799. 最长连续不重复子序列
    public static int lengthOfLongestSub(int[] nums) {
        int n = nums.length;
        int[] temp = new int[100010];
        //HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            temp[nums[i]]++;
            while (temp[nums[i]] > 1) { //有重复元素
                temp[nums[j]]--;
                j++;  //j跳到重复位置的下一位置
            }
            //if (map.containsKey(nums[i])) {
            //    j = Math.max(j, map.get(nums[i]) + 1); //j跳到重复位置的下一位置，但不往回跳
            //}
            //map.put(nums[i], i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
