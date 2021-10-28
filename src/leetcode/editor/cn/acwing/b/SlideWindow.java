package leetcode.editor.cn.acwing.b;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-28 16:42
 * @ClassName SlideWindow
 * @Description: 单调队列：滑动窗口
 */

public class SlideWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int len = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int[] min = minSlidingWindow(nums, len);
        for (int i = 0; i < n - len + 1; i++) {
            writer.write(min[i] + " ");
        }
        writer.write("\n");
        int[] max = maxSlidingWindow(nums, len);
        for (int i = 0; i < n - len + 1; i++) {
            writer.write(max[i] + " ");
        }
        writer.flush();
        reader.close();
        writer.close();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new LinkedList<>();
        // 结果数组
        int[] result = new int[n-k+1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {  //j为窗口右边界，i为窗口左边界
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减 ，严格递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0){
                result[i] = deque.peekFirst();
            }
        }
        return result;
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n-k+1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {  //j为窗口右边界，i为窗口左边界
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() > nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if(i >= 0){
                result[i] = deque.peekFirst();
            }
        }
        return result;
    }

}
