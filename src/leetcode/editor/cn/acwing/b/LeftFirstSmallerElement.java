package leetcode.editor.cn.acwing.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 16:14
 * @ClassName NextGreaterElement
 * @Description: 单调栈：左边第一个比它小的数
 */

public class LeftFirstSmallerElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int[] res = leftFirstSmallerElement(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    //左边第一个比它小的数
    private static int[] leftFirstSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            while (!stack.isEmpty() && stack.peek() >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
