package leetcode.editor.cn.acwing.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021/11/06 15:55
 * @ClassName Divisor
 * @Description: 869. 试除法求约数
 */
public class Divisor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(reader.readLine());
            Queue<Integer> heap = isDivisor(x);
            while (!heap.isEmpty()){
                System.out.print(heap.poll() + " ");
            }
            System.out.println();
        }
    }

    private static Queue<Integer> isDivisor(int x) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                heap.offer(i);
                if (x / i != i) {
                    heap.offer(x / i);
                }
            }
        }
        return heap;
    }
}
